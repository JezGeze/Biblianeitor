package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class AssosiationsActivity : AppCompatActivity(), AssosiationsContract.ContAssosiationsActivity {
    
    private lateinit var presenterAs: AssosiationsContract.ContAssosiationsPresenter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assosiations)
        
        initPresenter()
        getViews()
    }
    
    private fun initPresenter(){
        presenterAs = AssosiationsPresenter(this,BiblicReferences(this))
    }
    
    private fun getViews(){
        recyclerView = findViewById(R.id.rv_references_list)
    }
}
