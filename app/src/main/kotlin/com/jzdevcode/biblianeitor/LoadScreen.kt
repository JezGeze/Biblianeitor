package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import android.content.Intent

class LoadScreen : AppCompatActivity(), LoadScreenContract.LSView {

    private lateinit var tvLoad : TextView
    private lateinit var tvStatusBar : TextView
    
    private lateinit var presenterLS : LoadScreenContract.LSPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_load_screen)
        
        getViews()
        initPresenter()
        presenterLS.initDataBase(this)
        presenterLS.getAllColumns()
        changeActivity()
    }
    
    private fun getViews() {
        tvLoad = findViewById(R.id.tv_load)
        tvStatusBar = findViewById(R.id.tv_status_bar)
    }
    
    private fun initPresenter() {
        presenterLS = LoadScreenPresenter(this, BiblicReferences(this))
    }
    
    private fun changeActivity(){
        val intent = Intent(this, PrincipalMenuActivity::class.java)
        startActivity(intent)
    }
    
    override fun showMessage(text : String){
        tvLoad.setText(text)
    }
    
    override fun showMessageStatusBar(text : String){
        tvStatusBar.setText(text)
    }
    
}
