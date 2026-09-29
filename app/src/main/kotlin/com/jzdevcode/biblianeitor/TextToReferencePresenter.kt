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
    private var referencesExistents = mutableListOf<ReferencesEntity>()
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
        val listSize = referencesExistents.size
        if (listSize > 1){
            val randomNumber = Random.nextInt(listSize)
            viewTTR.showMessage("index $index size $listSize")
            return randomNumber
        } else {
            val lastNumber = 0
            return lastNumber
        }
        
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
                referencesExistents.addAll(referencesEntityList)
                index = getSizeReferencesEntityListAndReturnRandomNumber()
                viewTTR.showScreenText(referencesExistents[index].text)
                counter = 11
            }
        }while(counter <= 10)
    }
    
    //clearScreen() se implementa en referencesExistentsControl() en el else
    private fun clearScreen(){
        viewTTR.showScreenText("")
        viewTTR.clearScreenBiblicReference("")
        
        index = getSizeReferencesEntityListAndReturnRandomNumber()
        viewTTR.showScreenText(referencesExistents[index].text)
    }
    
    //referencesExistentsControl() se implementa en validateScreenTextAndScreenReference() en el primer if
    private fun referencesExistentsControl(){
        if (referencesExistents.isEmpty()){
            referencesExistents.addAll(referencesEntityList)
            viewTTR.showMessage("Ronda Nueva")
        } else {
            referencesExistents.removeAt(index)
            clearScreen()
        }
    }
    
    
    override fun validateScreenTextAndScreenReference(){
        
        val etStringToValidate = viewTTR.getEditTextString()
        
        if (etStringToValidate == referencesExistents[index].reference){
            viewTTR.showMessage("Correcto")
            referencesExistents.removeAt(index)
            
            if (referencesExistents.isNotEmpty()){
            viewTTR.showScreenText("")
            viewTTR.clearScreenBiblicReference("")
            index = getSizeReferencesEntityListAndReturnRandomNumber()
            viewTTR.showScreenText(referencesExistents[index].text)
            } else {
                referencesExistents.addAll(referencesEntityList)
                viewTTR.showMessage("Ronda Nueva")
                viewTTR.showScreenText("")
                viewTTR.clearScreenBiblicReference("")
                index = getSizeReferencesEntityListAndReturnRandomNumber()
                viewTTR.showScreenText(referencesExistents[index].text)
                
            }
            
            
            //referencesExistentsControl()
        } else if (etStringToValidate.isEmpty()){
            viewTTR.showMessage("Campo Vacío")
        } else {
            viewTTR.showMessage("Incorrecto")
            viewTTR.showAssosiation(referencesExistents[index].assosiation, referencesExistents[index].text, referencesExistents[index].reference)
        }
    }
    
}
