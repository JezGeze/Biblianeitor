package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.jzdevcode.biblianeitor.recyclerView.AssosiationsAdapter

class AssosiationsActivity : AppCompatActivity(), AssosiationsContract.ContAssosiationsActivity {
    
    private lateinit var presenterAs: AssosiationsContract.ContAssosiationsPresenter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assosiations)
        
        initPresenter()
        getViews()
        presenterAs.getAllTextsColumns()
    }
    
    private fun initPresenter(){
        presenterAs = AssosiationsPresenter(this,BiblicReferences(this))
    }
    
    private fun getViews(){
        recyclerView = findViewById(R.id.rv_references_list)
    }
    
    override fun adaptersInfo(textsList: List<String>){
        val adapter = AssosiationsAdapter(textsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
