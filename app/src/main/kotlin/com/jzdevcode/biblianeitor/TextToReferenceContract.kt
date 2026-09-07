package com.jzdevcode.biblianeitor

import com.jzdevcode.biblianeitor.database.ReferencesEntity

interface TextToReferenceContract {

    interface ContViewTTR {
        fun getEditTextString(): String
        fun showMessage(text: String)
        fun showScreenText(screenText: String)
        fun showAssosiation(assosiation: String, biblicReference: String, biblicText: String)
    }
    
    interface ContPresenterTTR {
        fun getAllColumnsForValidate()
        suspend fun screenText()
        fun validateScreenTextAndScreenReference()
    }
    
    interface ContModelTTR {
        suspend fun getAllColumnsFromDB(): List<ReferencesEntity>
    }
    
}
