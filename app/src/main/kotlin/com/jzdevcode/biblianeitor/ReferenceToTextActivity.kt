package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

import com.jzdevcode.biblianeitor.database.ReferencesEntity
import android.app.AlertDialog

class ReferenceToTextActivity : AppCompatActivity(), ReferenceToTextContract.ViewRTT {

    private lateinit var presenterRTT: ReferenceToTextContract.PresenterRTT
    
    private lateinit var tvBiblicText: TextView
    private lateinit var etBiblicTextAnswer: EditText
    private lateinit var btnValidateAnswer: Button
    private lateinit var btnChangeModality: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reference_to_text)
        
        getViews()
        initPresenter()
        presenterRTT.getAllColumnsForValidate()
        presenterRTT.screenText()
        buttonsAction()
    }
    
    
    private fun getViews(){
        tvBiblicText = findViewById(R.id.tv_biblic_text)
        etBiblicTextAnswer = findViewById(R.id.et_biblic_text_answer)
        btnValidateAnswer = findViewById(R.id.btn_validate_answer)
        btnChangeModality = findViewById(R.id.btn_change_modality)
    }
    
    private fun buttonsAction(){
        btnValidateAnswer.setOnClickListener{
            presenterRTT.validateScreenTextAndScreenReference()
        }
    }
    
    private fun initPresenter(){
        presenterRTT = ReferenceToTextPresenter(this, BiblicReferences(this))
    }
    ///////////////////////
    
    override fun showScreenText(screenText: String){
        tvBiblicText.setText("CITA BÍBLICA: $screenText")
    }
    
    override fun clearScreenBiblicReference(screenBiblicReference: String){
        etBiblicTextAnswer.setText(screenBiblicReference)
    }
    
    override fun getEditTextString(): String{
        val string = etBiblicTextAnswer.text.toString()
        return string
    }
    
    override fun showMessage(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    
    //showAssosiation muestra un cuadro de alert
    override fun showAssosiation(assosiation: String, biblicReference: String, biblicText: String){
        AlertDialog.Builder(this)
        .setTitle("Asosiación de $biblicReference")
        .setMessage("Asociación: $assosiation \nTexto: $biblicText")
        .setPositiveButton("Cerrar", null)
        .show()
    }
}
