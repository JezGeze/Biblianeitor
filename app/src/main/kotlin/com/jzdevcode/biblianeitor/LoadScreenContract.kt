package com.jzdevcode.biblianeitor

import android.content.Context
import com.jzdevcode.biblianeitor.database.ReferencesEntity

interface LoadScreenContract {

    interface LSView{
        fun showMessage(text: String)
        fun showMessageStatusBar(text : String)
    }
    
    interface LSPresenter{
        fun initDataBase(context: Context)
        fun getAllColumns()
    }
    
    interface LSModel{
        suspend fun getAllColumnsFromDB(): List<ReferencesEntity>
    }
    
}
