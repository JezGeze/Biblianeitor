package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import com.jzdevcode.biblianeitor.database.ReferencesEntity
import android.widget.Toast

class AddTextActivity : AppCompatActivity(), AddTextContract.ContViewAT{

    private lateinit var presenterAT: AddTextContract.ContPresenterAT
    
    private lateinit var etSetReference: EditText
    private lateinit var etSetText: EditText
    private lateinit var etSetAssosiation: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_text)
        
        initPresenter()
        getViews()
        buttonsActions()
        
    }
    
    private fun getViews() {
        etSetReference = findViewById(R.id.et_set_reference)
        etSetText = findViewById(R.id.et_set_text)
        etSetAssosiation = findViewById(R.id.et_set_assosiation)
        btnSave = findViewById(R.id.btn_save)
    }
    
    private fun initPresenter(){
        presenterAT = AddTextPresenter(this,BiblicReferences(this))
    }
    
    private fun buttonsActions() {
        btnSave.setOnClickListener{
            presenterAT.addBiblicReference()
        }
    }
    
    override fun createNewReferenceEntity(): ReferencesEntity{
        val setReference = etSetReference.text.toString()
        val setText = etSetText.text.toString()
        val setAssosiation = etSetAssosiation.text.toString()
        
        return ReferencesEntity(0,setReference,setText,setAssosiation)
    }
    
    override fun showTextSavedMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
