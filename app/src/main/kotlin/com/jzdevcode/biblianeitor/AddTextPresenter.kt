package com.jzdevcode.biblianeitor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTextPresenter(
    private val viewAT: AddTextContract.ContViewAT, 
    private val modelAT: AddTextContract.ContModelAT
    ) : AddTextContract.ContPresenterAT {
    
    override fun addBiblicReference(){
        CoroutineScope(Dispatchers.IO).launch{
            val referenceEntity = viewAT.createNewReferenceEntity()
            modelAT.addReference(referenceEntity)
        }
        viewAT.showTextSavedMessage("Texto bíblico guardado con éxito")
        
    }
    
}
