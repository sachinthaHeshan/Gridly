package com.example.gridly

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var registerButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        registerButton = findViewById(R.id.register_submit_button)
    }
    
    private fun setupClickListeners() {
        registerButton.setOnClickListener {
            finish()
        }
    }
}
