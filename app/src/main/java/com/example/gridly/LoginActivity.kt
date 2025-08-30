package com.example.gridly

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    
    private lateinit var loginButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        loginButton = findViewById(R.id.login_submit_button)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            navigateToHome()
        }
    }
    
    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
    }
}
