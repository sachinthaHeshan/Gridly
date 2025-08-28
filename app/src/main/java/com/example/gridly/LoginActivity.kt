package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var loginButton: MaterialButton
    
    private lateinit var emailLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    
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
        
        emailLayout = findViewById(R.id.login_email_layout)
        passwordLayout = findViewById(R.id.login_password_layout)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            if (validateForm()) {
                performLogin()
            }
        }
    }
    
    private fun validateForm(): Boolean {
        var isValid = true
        
        // Clear previous errors
        clearErrors()
        
        // Validate email
        val email = emailInput.text.toString().trim()
        if (email.isEmpty()) {
            emailLayout.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.error = "Please enter a valid email address"
            isValid = false
        }
        
        // Validate password
        val password = passwordInput.text.toString()
        if (password.isEmpty()) {
            passwordLayout.error = "Password is required"
            isValid = false
        } else if (password.length < 6) {
            passwordLayout.error = "Password must be at least 6 characters"
            isValid = false
        }
        
        return isValid
    }
    
    private fun clearErrors() {
        emailLayout.error = null
        passwordLayout.error = null
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
