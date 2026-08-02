package com.jzdevcode.biblianeitor

import android.content.Context

class BiblicReferences(context: Context) : TextToReferenceContract.ContModelTTR {
    
    override fun sendPrueba(): String {
        val prueba = "Juan 3:16"
        return prueba
    }
}
