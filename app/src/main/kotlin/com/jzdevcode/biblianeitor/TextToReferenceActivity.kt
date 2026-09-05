package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

import com.jzdevcode.biblianeitor.database.ReferencesEntity

class TextToReferenceActivity : AppCompatActivity(), TextToReferenceContract.ContViewTTR {

    private lateinit var presenterTTR: TextToReferenceContract.ContPresenterTTR
    private lateinit var etBiblicText: EditText
    private lateinit var etBiblicTextAnswer: EditText
    private lateinit var btnValidateAnswer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_reference)
        
        initPresenter()
        getViews()
        presenterTTR.getAllColumnsForValidate()
        buttonsActions()
    }
    
     fun initPresenter(){
        presenterTTR = TextToReferencePresenter(this,BiblicReferences(this))
    }
    
    private fun getViews(){
        etBiblicText = findViewById(R.id.et_biblic_text)
        etBiblicTextAnswer = findViewById(R.id.et_biblic_text_answer)
        btnValidateAnswer = findViewById(R.id.btn_validate_answer)
    }
    
    private fun buttonsActions(){
        btnValidateAnswer.setOnClickListener{
            presenterTTR.validateScreenTextAndScreenReference()
        }
    }
    
    override fun showScreenText(screenText: String){
        etBiblicText.setText(screenText)
    }
    
     /*override fun showScreenText2(screenText: List<ReferencesEntity>){
        val re = screenText
        etBiblicText.setText("h $re")
    }*/
    
    
    override fun getEditTextString(): String{
        val string = etBiblicTextAnswer.text.toString()
        return string
    }
    
    override fun showMessage(text: String){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
