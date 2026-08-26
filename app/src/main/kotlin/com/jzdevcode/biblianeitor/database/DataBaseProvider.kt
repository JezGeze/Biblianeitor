package com.jzdevcode.biblianeitor.database

import android.content.Context
import androidx.room.Room

object DataBaseProvider {
    private var database: AppDataBase? = null
    
    fun createDataBase(context: Context): AppDataBase{
        if (database == null){
            database = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "references.db"
            ).build()
        }
        return database!!
    }
}
