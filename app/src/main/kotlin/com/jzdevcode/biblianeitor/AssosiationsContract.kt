package com.jzdevcode.biblianeitor

interface AssosiationsContract {
    
    interface ContAssosiationsActivity{
        fun adaptersInfo(textsList: List<String>)
    }
    
    interface ContAssosiationsPresenter{
        fun getAllTextsColumns()
        suspend fun setRecyclerView()
    }
    
    interface ContAssosiationsModel{
        suspend fun getAllTextsColumnsFromDB(): List<String>
    }
}
