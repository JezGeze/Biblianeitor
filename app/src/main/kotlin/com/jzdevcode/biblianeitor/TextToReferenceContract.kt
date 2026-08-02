package com.jzdevcode.biblianeitor

interface TextToReferenceContract {

    interface ContViewTTR {
        fun getEditTextString(): String
        fun showMessage(text: String)
        fun showScreenText(screenText: String)
    }
    
    interface ContPresenterTTR {
        fun screenText()
        fun validate()
    }
    
    interface ContModelTTR {
        fun sendPrueba(): String
    }
    
}
