package com.jzdevcode.biblianeitor.database

import android.content.Context
import com.jzdevcode.biblianeitor.database.DataBaseProvider
import com.jzdevcode.biblianeitor.database.ReferencesDao
import com.jzdevcode.biblianeitor.database.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val referencesDao: ReferencesDao) {
        
        //Para implementarse en AddTextActivity
        suspend fun insertReference(referencesEntity: ReferencesEntity) {
            referencesDao.insertReferences(referencesEntity)
        }
        //Para implementarse en TextToReferenceActivity
        suspend fun getAllColumnsFromDao(): List<ReferencesEntity> {
            return referencesDao.getAllColumns()
        }
        
        //Para implementarse en AssosiationsActivity
        suspend fun getAllTextsColumnsFromDao(): List<String>{
            return referencesDao.getAllTextsColumns()
        }
        
        suspend fun countReferencesFromDao(): Int {
            return referencesDao.countReferences()
        }
        
}
