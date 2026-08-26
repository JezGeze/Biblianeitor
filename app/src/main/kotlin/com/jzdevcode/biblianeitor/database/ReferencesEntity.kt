package com.jzdevcode.biblianeitor.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "references_table")
data class ReferencesEntity(
    
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val reference: String,
    val assosiation: String
)
