package com.example.gridly

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var contactNumberInput: EditText
    private lateinit var registerButton: MaterialButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        firstNameInput = findViewById(R.id.first_name_input)
        lastNameInput = findViewById(R.id.last_name_input)
        emailInput = findViewById(R.id.email_input)
        contactNumberInput = findViewById(R.id.contact_number_input)
        registerButton = findViewById(R.id.register_submit_button)
    }
    
    private fun setupClickListeners() {
        registerButton.setOnClickListener {
            performRegistration()
        }
    }
    
    private fun performRegistration() {
        // Get form data
        val firstName = firstNameInput.text.toString().trim()
        val lastName = lastNameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()
        val contactNumber = contactNumberInput.text.toString().trim()
        
        // Validate required fields
        if (firstName.isEmpty()) {
            firstNameInput.error = "First name is required"
            return
        }
        
        if (lastName.isEmpty()) {
            lastNameInput.error = "Last name is required"
            return
        }
        
        if (email.isEmpty()) {
            emailInput.error = "Email is required"
            return
        }
        
        if (contactNumber.isEmpty()) {
            contactNumberInput.error = "Contact number is required"
            return
        }
        

        Toast.makeText(
            this,
            "Registration successful for $firstName $lastName",
            Toast.LENGTH_LONG
        ).show()

        finish()
    }
}
