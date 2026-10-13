package com.jzdevcode.biblianeitor

import android.content.Context
import com.jzdevcode.biblianeitor.database.ReferencesEntity
//imports de Room
import com.jzdevcode.biblianeitor.database.DataBaseProvider
//imports corrutinas
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class LoadScreenPresenter(
        private val viewLS: LoadScreenContract.LSView,
        private val modelLS: LoadScreenContract.LSModel
    ) : LoadScreenContract.LSPresenter {
    
    companion object{
        var referencesEntityList = emptyList<ReferencesEntity>()
    }
    
    //initDataBase() esta ligado a DataBaseProvider, es una clase de Room, crea el archivo de la base de datos de Room, y si existe, lo carga
    override fun initDataBase(context: Context){
        viewLS.showMessage("CARGANDO: BASE DE DATOS...")
        DataBaseProvider.createDataBase(context)
        //Toast.makeText(context,"DB Cargada", Toast.LENGTH_SHORT).show()
        viewLS.showMessageStatusBar("CARGADO: 50% &&&&&")
    }
    
     override fun getAllColumns(){
        CoroutineScope(Dispatchers.IO).launch{
        
            referencesEntityList = modelLS.getAllColumnsFromDB()
                
                withContext(Dispatchers.Main){
                    var counter = 0
                do{
                    if (referencesEntityList.isEmpty()){
                        counter++
                        viewLS.showMessage("CARGANDO: CONSULTANDO A ROOM...")
                        delay(1000)
                    } else if (referencesEntityList.isNotEmpty()){
                        viewLS.showMessage("INICIANDO...")
                        viewLS.showMessageStatusBar("CARGADO: 100% &&&&&&&&&&")
                        counter = 11
                    }
                }while(counter <= 10)
               }
            }
      }     
    
}
