package com.jzdevcode.biblianeitor.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReferencesDao {
    
    @Insert
    suspend fun insertReferences(referencesEntity: ReferencesEntity)
    
    @Query("SELECT * FROM references_table")
    suspend fun getAllColumns(): List<ReferencesEntity>
    
    @Query("SELECT text FROM references_table")
    suspend fun getAllTextsColumns(): List<String>
    
    @Query("SELECT COUNT(*) FROM references_table")
    suspend fun countReferences(): Int
    
}
