package com.jzdevcode.biblianeitor.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReferencesDao {
    
    @Insert
    suspend fun insertReference(referencesEntity: ReferencesEntity)
    
    @Query("SELECT COUNT(*) FROM references_table")
    suspend fun countReferences(): Int
    
}
