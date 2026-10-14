package com.jzdevcode.biblianeitor

import com.jzdevcode.biblianeitor.database.ReferencesEntity

interface AddTextContract {
    
    interface ContViewAT{
        fun createNewReferenceEntity(): ReferencesEntity
        fun showTextSavedMessage(message: String)
        fun changeActivityToRefresh()
    }
    
    interface ContPresenterAT{
        fun addBiblicReference()
    }
    
    interface ContModelAT{
        suspend fun addReference(referencesEntity: ReferencesEntity)
    }
    
}
