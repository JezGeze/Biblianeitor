package com.jzdevcode.biblianeitor.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ReferencesEntity::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun referencesDao(): ReferencesDao
    
}
