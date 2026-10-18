package com.jzdevcode.biblianeitor

interface ReferenceToTextContract {
    
    interface ViewRTT{
        fun getEditTextString(): String
        fun showMessage(text: String)
        fun showScreenText(screenText: String)
        fun clearScreenBiblicReference(screenBiblicReference: String)
        fun showAssosiation(assosiation: String, biblicReference: String, biblicText: String)
    }
    
    interface PresenterRTT{
        fun getAllColumnsForValidate()
        //suspend fun screenText()
        fun screenText()
        fun validateScreenTextAndScreenReference()
    }
    
    interface ModelRTT{
        //suspend fun getAllColumnsFromDB(): List<ReferencesEntity>
    }
}
