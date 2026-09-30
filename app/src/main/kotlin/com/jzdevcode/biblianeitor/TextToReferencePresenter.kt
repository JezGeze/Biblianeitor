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
    private fun getSizeReferencesExistentsAndReturnRandomNumber(): Int {
        val listSize = referencesExistents.size
        if (listSize > 1){
            val randomNumber = Random.nextInt(listSize)
            return randomNumber
        } else {
            val lastNumber = 0
            return lastNumber
        }
        
    }
    
    //NOTA IMPORTANTE: HACER QUE EL USUARIO PONGA UNA PRIMERA ASOCIACION O TODO VA A CRASHEAR (BORRAR ESTE COMENTARIO UNA VEZ COMPLETADA LA TAREA)
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
                index = getSizeReferencesExistentsAndReturnRandomNumber()
                viewTTR.showScreenText(referencesExistents[index].text)
                counter = 11
            }
        }while(counter <= 10)
    }
    
    //clearScreen() se implementa en referencesExistentsControl() en el else
    private fun clearScreen(){
        viewTTR.showScreenText("")
        viewTTR.clearScreenBiblicReference("")
        
        index = getSizeReferencesExistentsAndReturnRandomNumber()
        viewTTR.showScreenText(referencesExistents[index].text)
    }
    
    //referencesExistentsControl() se implementa en validateScreenTextAndScreenReference() en el primer if
    private fun referencesExistentsControl(){
        referencesExistents.removeAt(index)
            
            if (referencesExistents.isNotEmpty()){
            clearScreen()
            } else {
                referencesExistents.addAll(referencesEntityList)
                viewTTR.showMessage("Ronda Nueva")
                clearScreen()
            }
        /*Flujo de trabajo: 1. el metodo screenText() llena con un numero al azar la variable index.
                            2. cuando una respuesta es correcta borra el elemento senalado por el index y se pasa a comprobar:
                            si referencesExistents no esta vacio aun se ejecuta screenText(), si ya esta vacio se vuelve a llenar referencesExistents
        */    
    }
    
    //validateScreenTextAndScreenReference() se implementa cada vez que el boton de validar es presionado
    override fun validateScreenTextAndScreenReference(){
        
        val etStringToValidate = viewTTR.getEditTextString()
        
        if (etStringToValidate == referencesExistents[index].reference){
            viewTTR.showMessage("Correcto")
            referencesExistentsControl()
            
        } else if (etStringToValidate.isEmpty()){
            viewTTR.showMessage("Campo Vacío")
            
        } else {
            viewTTR.showMessage("Incorrecto")
            viewTTR.showAssosiation(referencesExistents[index].assosiation, referencesExistents[index].text, referencesExistents[index].reference)
        }
    }
    
}
