package com.jzdevcode.biblianeitor

import kotlin.random.Random
import com.jzdevcode.biblianeitor.database.ReferencesEntity
import com.jzdevcode.biblianeitor.LoadScreenPresenter

class ReferenceToTextPresenter(
    val viewRTT: ReferenceToTextContract.ViewRTT,
    val modelRTT: ReferenceToTextContract.ModelRTT
) : ReferenceToTextContract.PresenterRTT {

     //private var referencesEntityList = emptyList<ReferencesEntity>()
    private var referencesExistents = mutableListOf<ReferencesEntity>()
    private var index = 0
    
    override fun getAllColumnsForValidate(){
        referencesExistents.addAll(LoadScreenPresenter.referencesEntityList)
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
    //screenText() se implementa en TextToReferencesActivity, y lo que hace es pintar en pantalla las citas biblicas
    override fun screenText() {
        if(referencesExistents.isNotEmpty()){
            index = getSizeReferencesExistentsAndReturnRandomNumber()
            viewRTT.showScreenText(referencesExistents[index].reference)
        } else {
            viewRTT.showMessage("Añada una primera asociación")
        }
    }  
    
    
    //clearScreen() se implementa en referencesExistentsControl() en el else
    private fun clearScreen(){
        viewRTT.showScreenText("")
        viewRTT.clearScreenBiblicReference("")
        
        index = getSizeReferencesExistentsAndReturnRandomNumber()
        viewRTT.showScreenText(referencesExistents[index].reference)
    }
    
    //referencesExistentsControl() se implementa en validateScreenTextAndScreenReference() en el primer if
    private fun referencesExistentsControl(){
        referencesExistents.removeAt(index)
            
            if (referencesExistents.isNotEmpty()){
            clearScreen()
            } else {
                referencesExistents.addAll(LoadScreenPresenter.referencesEntityList)
                viewRTT.showMessage("Ronda Nueva")
                clearScreen()
            }
        /*Flujo de trabajo: 1. el metodo screenText() llena con un numero al azar la variable index.
                            2. cuando una respuesta es correcta borra el elemento senalado por el index y se pasa a comprobar:
                            si referencesExistents no esta vacio aun se ejecuta screenText(), si ya esta vacio se vuelve a llenar referencesExistents
        */    
    }
    
    //validateScreenTextAndScreenReference() se implementa cada vez que el boton de validar es presionado
    override fun validateScreenTextAndScreenReference(){
        
        val etStringToValidate = viewRTT.getEditTextString()
        
        if (etStringToValidate == referencesExistents[index].text){
            viewRTT.showMessage("Correcto")
            referencesExistentsControl()
            
        } else if (etStringToValidate.isEmpty()){
            viewRTT.showMessage("Campo Vacío")
            
        } else {
            viewRTT.showMessage("Incorrecto")
            viewRTT.showAssosiation(referencesExistents[index].assosiation, referencesExistents[index].text, referencesExistents[index].reference)
        }
    }
    
}