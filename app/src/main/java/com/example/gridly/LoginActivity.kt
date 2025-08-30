package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        emailInput = findViewById(R.id.login_email_input)
        passwordInput = findViewById(R.id.login_password_input)
        loginButton = findViewById(R.id.login_submit_button)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            performLogin()
        }
    }
    
    private fun performLogin() {
        // Get form data
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString()
        
        // TODO: Implement actual authentication logic here
        // For now, just show success message and navigate to home
        Toast.makeText(
            this,
            "Login successful for $email",
            Toast.LENGTH_SHORT
        ).show()
        
        // Navigate to home activity
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
