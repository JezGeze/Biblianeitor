package com.jzdevcode.biblianeitor

import android.content.Context

interface LoadScreenContract {

    interface LSView{
        fun showMessage(text: String)
    }
    
    interface LSPresenter{
        fun initDataBase(context: Context)
    }
    
    interface LSModel{
        
    }
    
}
