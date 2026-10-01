package com.jzdevcode.biblianeitor

import android.content.Context
import com.jzdevcode.biblianeitor.database.Repository
import com.jzdevcode.biblianeitor.database.DataBaseProvider
import com.jzdevcode.biblianeitor.database.ReferencesEntity

class BiblicReferences(context: Context) : TextToReferenceContract.ContModelTTR, AddTextContract.ContModelAT, AssosiationsContract.ContAssosiationsModel, LoadScreenContract.LSModel {
    
    private val repository: Repository
    
    init{
        val db = DataBaseProvider.createDataBase(context)
        repository = Repository(db.referencesDao())
    }
    
    //addReference(referencesEntity: ReferencesEntity) se implementa en AddTextPresenter
    override suspend fun addReference(referencesEntity: ReferencesEntity){
        repository.insertReference(referencesEntity)
    }
    
    //getTextsColumnsFromDB(): List<String> se implementa en TextToReferencePresenter y en AssosiationsPresenter
    override suspend fun getAllColumnsFromDB(): List<ReferencesEntity> {
        return repository.getAllColumnsFromDao()
    }
    
    override suspend fun getAllTextsColumnsFromDB(): List<String>{
        return repository.getAllTextsColumnsFromDao()
    }
    
    suspend fun getAllColumnsNumberFromDB(): Int{
        return repository.countReferencesFromDao()
    }
    
}
