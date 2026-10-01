package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

class LoadScreen : AppCompatActivity(), LoadScreenContract.LSView {

    private lateinit var tvLoad : TextView
    
    private lateinit var presenterLS : LoadScreenContract.LSPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_load_screen)
        
        getViews()
        initPresenter()
        presenterLS.initDataBase(this)
    }
    
    private fun getViews() {
        tvLoad = findViewById(R.id.tv_load)
    }
    
    private fun initPresenter() {
        presenterLS = LoadScreenPresenter(this, BiblicReferences(this))
    }
    
    override fun showMessage(text : String){
        tvLoad.setText(text)
    }
    
}
