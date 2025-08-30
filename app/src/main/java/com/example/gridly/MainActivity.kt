package com.example.gridly

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    
    private lateinit var loginButton: MaterialButton
    private lateinit var registerButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        loginButton = findViewById(R.id.login_button)
        registerButton = findViewById(R.id.register_button)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}