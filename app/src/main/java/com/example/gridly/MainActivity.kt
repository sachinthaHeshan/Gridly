package com.example.gridly

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    
    private lateinit var loginButton: MaterialButton
    private lateinit var registerButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        loginButton = findViewById(R.id.login_button)
        registerButton = findViewById(R.id.register_button)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            // TODO: Navigate to login screen
            Toast.makeText(this, "Login clicked - Feature coming soon!", Toast.LENGTH_SHORT).show()
        }
        
        registerButton.setOnClickListener {
            // TODO: Navigate to registration screen
            Toast.makeText(this, "Register clicked - Feature coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}