package com.jzdevcode.biblianeitor

class TextToReferencePresenter(
    private val viewTTR: TextToReferenceContract.ContViewTTR, 
    private val modelTTR: TextToReferenceContract.ContModelTTR
    ) : TextToReferenceContract.ContPresenterTTR {
    
    val prueba = modelTTR.sendPrueba()
    
    override fun screenText(){
        viewTTR.showScreenText(prueba)
    }
    
    override fun validate(){
        
        val etStringToValidate = viewTTR.getEditTextString()
        
        if (prueba == etStringToValidate){
            viewTTR.showMessage("Correcto")
        } else {
            viewTTR.showMessage("Incorrecto")
        }
    }
}
