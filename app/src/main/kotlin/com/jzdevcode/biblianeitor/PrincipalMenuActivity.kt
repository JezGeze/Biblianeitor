package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PrincipalMenuActivity : AppCompatActivity() {

    private lateinit var btnTextReference: Button
    private lateinit var btnReferenceText: Button
    private lateinit var btnAssosiations: Button
    private lateinit var btnAddText: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_principal_menu)
        
        getViews()
        buttonsActions()
    }
    
    private fun getViews(){
        btnTextReference = findViewById(R.id.btn_text_reference)
        btnReferenceText = findViewById(R.id.btn_reference_text)
        btnAssosiations = findViewById(R.id.btn_assosiations)
        btnAddText = findViewById(R.id.btn_add_text)
    }
    
    private fun buttonsActions(){
        btnTextReference.setOnClickListener{
            changeActivity(TextToReferenceActivity::class.java)
        }
        
        btnAddText.setOnClickListener{
            changeActivity(AddTextActivity::class.java)
        }
        
        btnAssosiations.setOnClickListener{
            changeActivity(AssosiationsActivity::class.java)
        }
    }
    
    //Recordar que cada vez que se use esta funcion se deve escrivir ::Class.java. ejemplo: changeActivity(TextToReferencesActivity::class.java)
    private fun changeActivity(activity: Class<*>){
        val intent = Intent(this,activity)
        startActivity(intent)
    }
    
   
    
}