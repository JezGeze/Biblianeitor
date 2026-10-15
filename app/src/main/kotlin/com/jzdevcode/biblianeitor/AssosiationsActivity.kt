package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.jzdevcode.biblianeitor.recyclerView.AssosiationsAdapter
import androidx.appcompat.app.AlertDialog

class AssosiationsActivity : AppCompatActivity(), AssosiationsContract.ContAssosiationsActivity {
    
    private lateinit var presenterAs: AssosiationsContract.ContAssosiationsPresenter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assosiations)
        
        initPresenter()
        getViews()
        presenterAs.setRecyclerView()
    }
    
    private fun initPresenter(){
        presenterAs = AssosiationsPresenter(this,BiblicReferences(this))
    }
    
    private fun getViews(){
        recyclerView = findViewById(R.id.rv_references_list)
    }
    
    override fun adaptersInfo(titlesList: List<String>, assosiationsList: List<String>, biblicReferencesList: List<String>){
        //val adapter = AssosiationsAdapter(this,titlesList,assosiationsList,biblicReferencesList)
        val adapter = AssosiationsAdapter(titlesList) {index -> alertDialogShow(index,titlesList, assosiationsList, biblicReferencesList)}
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    
    override fun showMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    
    override fun refreshScreen(){
        val intent = Intent(this,LoadScreen::class.java)
        startActivity(intent)
        finish()
    }
    
    private fun alertDialogShow(index: Int,titlesList: List<String>, assosiationsList: List<String>, biblicReferencesList: List<String>){
        AlertDialog.Builder(this)
            .setTitle("Asosiación de ${titlesList[index]}")
            .setMessage("Asociación: ${assosiationsList[index]} \nTexto: ${biblicReferencesList[index]}")
            .setPositiveButton("Cerrar", null)
            .setNegativeButton("Borrar"){_,_-> alertDialogDelete(index,titlesList)}
            .show()
    }
    
    private fun alertDialogDelete(index: Int, titlesList: List<String>){
        AlertDialog.Builder(this)
            .setTitle("Está seguro de borrar ${titlesList[index]}?")
            .setMessage("La acción es irreversible")
            .setPositiveButton("No", null)
            .setNegativeButton("Sí"){_,_-> presenterAs.deleteAssosiation(index)}
            .show()
    }
}
