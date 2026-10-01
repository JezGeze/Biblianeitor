package com.jzdevcode.biblianeitor

import android.content.Context
//imports de Room
import com.jzdevcode.biblianeitor.database.DataBaseProvider

class LoadScreenPresenter(
        private val viewLS: LoadScreenContract.LSView,
        private val modelLS: LoadScreenContract.LSModel
    ) : LoadScreenContract.LSPresenter {
    
    //initDataBase() esta ligado a DataBaseProvider, es una clase de Room, crea el archivo de la base de datos de Room, y si existe, lo carga
    override fun initDataBase(context: Context){
        DataBaseProvider.createDataBase(context)
        //Toast.makeText(context,"DB Cargada", Toast.LENGTH_SHORT).show()
        viewLS.showMessage("CARGANDO: &&&&& Base de datos 50%")
    }
    
}
