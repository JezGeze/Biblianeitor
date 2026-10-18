package com.jzdevcode.biblianeitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ReferenceToTextActivity : AppCompatActivity(), ReferenceToTextContract.ViewRTT {

    private lateinit var presenterRTT: ReferenceToTextContract.PresenterRTT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reference_to_text)
        
        initPresenter()
    }
    
    private fun initPresenter(){
        presenterRTT = ReferenceToTextPresenter(this, BiblicReferences(this))
    }
}
