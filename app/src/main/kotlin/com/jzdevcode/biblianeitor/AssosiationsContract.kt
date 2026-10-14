package com.jzdevcode.biblianeitor

interface AssosiationsContract {
    
    interface ContAssosiationsActivity{
        fun adaptersInfo(titlesList: List<String>, assosiationsList: List<String>, biblicReferencesList: List<String>)
    }
    
    interface ContAssosiationsPresenter{
        fun setRecyclerView()
    }
    
    interface ContAssosiationsModel{
    }
}
