package com.jzdevcode.biblianeitor

import com.jzdevcode.biblianeitor.database.ReferencesEntity

interface AssosiationsContract {
    
    interface ContAssosiationsActivity{
        fun adaptersInfo(titlesList: List<String>, assosiationsList: List<String>, biblicReferencesList: List<String>)
        fun showMessage(message: String)
        fun refreshScreen()
    }
    
    interface ContAssosiationsPresenter{
        fun setRecyclerView()
        fun deleteAssosiation(index: Int)
    }
    
    interface ContAssosiationsModel{
        suspend fun deleteAssosiationFromDB(id: Int)
    }
}
