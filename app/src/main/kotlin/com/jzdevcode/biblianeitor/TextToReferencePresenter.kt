package com.jzdevcode.biblianeitor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.random.Random
import com.jzdevcode.biblianeitor.database.ReferencesEntity

class TextToReferencePresenter(
    private val viewTTR: TextToReferenceContract.ContViewTTR, 
    private val modelTTR: TextToReferenceContract.ContModelTTR
    ) : TextToReferenceContract.ContPresenterTTR {
    
    private var referencesEntityList = emptyList<ReferencesEntity>()
    private var index = 0
    
    override fun getAllColumnsForValidate(){
        CoroutineScope(Dispatchers.IO).launch{
                referencesEntityList = modelTTR.getAllColumnsFromDB()
                
                withContext(Dispatchers.Main){
                    screenText()
                }
            }
        }
        
    
    //getSizeReferencesEntityListAndReturnRandomNumber(): Int obtiene el tamaño de la lista devuelta por getAllColumnsForValidate y devuelve un numero al azar
    //Si referencesEntityList esta vacio, entonces este metodo hara crashear la app
    private fun getSizeReferencesEntityListAndReturnRandomNumber(): Int {
        val listSize = referencesEntityList.size
        var randomNumber = Random.nextInt(listSize)
        return randomNumber
    }
    
    //Si referencesEntityList esta vacio, entonces este metodo hara crashear la app
    //screenText() se implementa dentro de getAllColumnsForValidate(), y lo que hace es pintar en pantalla las citas biblicas
    override suspend fun screenText() {
        var counter = 0
        do{
            if (referencesEntityList.isEmpty()){
                counter++
                viewTTR.showMessage("Cargando")
                delay(1000)
            } else if (referencesEntityList.isNotEmpty()){
                index = getSizeReferencesEntityListAndReturnRandomNumber()
                viewTTR.showScreenText(referencesEntityList[index].text)
                counter = 11
            }
        }while(counter <= 10)
    }
    
    override fun validateScreenTextAndScreenReference(){
        
        val etStringToValidate = viewTTR.getEditTextString()
        
        if (etStringToValidate == referencesEntityList[index].reference){
            viewTTR.showMessage("Correcto")
        } else if (etStringToValidate.isEmpty()){
            viewTTR.showMessage("Campo Vacío")
        } else {
            viewTTR.showMessage("Incorrecto")
            viewTTR.showAssosiation(referencesEntityList[index].assosiation, referencesEntityList[index].text, referencesEntityList[index].reference)
        }
    }
}
