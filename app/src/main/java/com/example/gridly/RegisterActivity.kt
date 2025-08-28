package com.example.gridly

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var firstNameInput: TextInputEditText
    private lateinit var lastNameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var contactNumberInput: TextInputEditText
    private lateinit var countryDropdown: AutoCompleteTextView
    private lateinit var registerButton: MaterialButton
    
    private lateinit var firstNameLayout: TextInputLayout
    private lateinit var lastNameLayout: TextInputLayout
    private lateinit var emailLayout: TextInputLayout
    private lateinit var contactNumberLayout: TextInputLayout
    private lateinit var countryLayout: TextInputLayout
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        setupCountryDropdown()
        setupClickListeners()
    }
    
    private fun initViews() {
        firstNameInput = findViewById(R.id.first_name_input)
        lastNameInput = findViewById(R.id.last_name_input)
        emailInput = findViewById(R.id.email_input)
        contactNumberInput = findViewById(R.id.contact_number_input)
        countryDropdown = findViewById(R.id.country_dropdown)
        registerButton = findViewById(R.id.register_submit_button)
        
        firstNameLayout = findViewById(R.id.first_name_layout)
        lastNameLayout = findViewById(R.id.last_name_layout)
        emailLayout = findViewById(R.id.email_layout)
        contactNumberLayout = findViewById(R.id.contact_number_layout)
        countryLayout = findViewById(R.id.country_layout)
    }
    
    private fun setupCountryDropdown() {
        val countries = arrayOf(
            "+94 Sri Lanka",
            "+91 India",
            "+1 United States",
            "+44 United Kingdom",
            "+61 Australia",
            "+65 Singapore",
            "+971 UAE"
        )
        
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, countries)
        countryDropdown.setAdapter(adapter)
        countryDropdown.setText("+94 Sri Lanka", false)
    }
    
    private fun setupClickListeners() {
        registerButton.setOnClickListener {
            if (validateForm()) {
                performRegistration()
            }
        }
    }
    
    private fun validateForm(): Boolean {
        var isValid = true
        
        // Clear previous errors
        clearErrors()
        
        // Validate first name
        if (firstNameInput.text.toString().trim().isEmpty()) {
            firstNameLayout.error = "First name is required"
            isValid = false
        }
        
        // Validate last name
        if (lastNameInput.text.toString().trim().isEmpty()) {
            lastNameLayout.error = "Last name is required"
            isValid = false
        }
        
        // Validate email
        val email = emailInput.text.toString().trim()
        if (email.isEmpty()) {
            emailLayout.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.error = "Please enter a valid email address"
            isValid = false
        }
        
        // Validate contact number
        val contactNumber = contactNumberInput.text.toString().trim()
        if (contactNumber.isEmpty()) {
            contactNumberLayout.error = "Contact number is required"
            isValid = false
        } else if (contactNumber.length < 9) {
            contactNumberLayout.error = "Please enter a valid contact number"
            isValid = false
        }
        
        return isValid
    }
    
    private fun clearErrors() {
        firstNameLayout.error = null
        lastNameLayout.error = null
        emailLayout.error = null
        contactNumberLayout.error = null
    }
    
    private fun performRegistration() {
        // Get form data
        val firstName = firstNameInput.text.toString().trim()
        val lastName = lastNameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()
        val contactNumber = contactNumberInput.text.toString().trim()
        val country = countryDropdown.text.toString()
        
        // TODO: Implement actual registration logic here
        // For now, just show success message
        Toast.makeText(
            this,
            "Registration successful for $firstName $lastName",
            Toast.LENGTH_LONG
        ).show()
        
        // Navigate back to main activity or to a success screen
        finish()
    }
}
