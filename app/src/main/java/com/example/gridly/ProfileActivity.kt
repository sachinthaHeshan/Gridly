package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {
    
    // Header views
    private lateinit var notificationIcon: ImageView
    
    // Profile views
    private lateinit var profileImage: ImageView
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView
    
    // Profile details views
    private lateinit var firstNameValue: TextView
    private lateinit var lastNameValue: TextView
    private lateinit var emailValue: TextView
    private lateinit var contactNumberValue: TextView
    private lateinit var languageValue: TextView
    private lateinit var cityValue: TextView
    
    // Buttons
    private lateinit var logoutButton: MaterialButton
    
    // Navigation views
    private lateinit var navHome: ImageView
    private lateinit var navMap: ImageView
    private lateinit var navHistory: ImageView
    private lateinit var navProfile: ImageView
    private lateinit var navSettings: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        setupClickListeners()
        loadUserData()
    }
    
    private fun initViews() {
        // Header views
        notificationIcon = findViewById(R.id.notification_icon)
        
        // Profile views
        profileImage = findViewById(R.id.profile_image)
        userName = findViewById(R.id.user_name)
        userEmail = findViewById(R.id.user_email)
        
        // Profile details views
        firstNameValue = findViewById(R.id.first_name_value)
        lastNameValue = findViewById(R.id.last_name_value)
        emailValue = findViewById(R.id.email_value)
        contactNumberValue = findViewById(R.id.contact_number_value)
        languageValue = findViewById(R.id.language_value)
        cityValue = findViewById(R.id.city_value)
        
        // Buttons
        logoutButton = findViewById(R.id.logout_button)
        
        // Navigation views
        navHome = findViewById(R.id.nav_home)
        navMap = findViewById(R.id.nav_map)
        navHistory = findViewById(R.id.nav_history)
        navProfile = findViewById(R.id.nav_profile)
        navSettings = findViewById(R.id.nav_settings)
    }
    
    private fun setupClickListeners() {
        // Header click listeners
        notificationIcon.setOnClickListener {
            // TODO: Navigate to notifications
            Toast.makeText(this, "Notifications coming soon!", Toast.LENGTH_SHORT).show()
        }
        
        // Profile image click listener
        profileImage.setOnClickListener {
            // TODO: Option to change profile picture
            Toast.makeText(this, "Change profile picture coming soon!", Toast.LENGTH_SHORT).show()
        }
        
        // Logout button
        logoutButton.setOnClickListener {
            handleLogout()
        }
        
        // Bottom navigation click listeners
        navHome.setOnClickListener {
            navigateToHome()
        }
        
        navMap.setOnClickListener {
            // TODO: Navigate to map
            Toast.makeText(this, "Map coming soon!", Toast.LENGTH_SHORT).show()
        }
        
        navHistory.setOnClickListener {
            navigateToMyCharger()
        }
        
        navProfile.setOnClickListener {
            // Already on profile page - do nothing
        }
        
        navSettings.setOnClickListener {
            // TODO: Navigate to settings
            Toast.makeText(this, "Settings coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun loadUserData() {
        // Load user data (in a real app, this would come from shared preferences, database, or API)
        userName.text = "Sachintha Heshan"
        userEmail.text = "sachintha@gmail.com"
        
        firstNameValue.text = "Sachintha"
        lastNameValue.text = "Heshan"
        emailValue.text = "sachintha@gmail.com"
        contactNumberValue.text = "+94 77 3845 338"
        languageValue.text = "English"
        cityValue.text = "Horana"
        
        // TODO: Load actual profile image
        // In a real app, you would load the user's profile image here
    }
    
    private fun handleLogout() {
        // Show confirmation dialog or directly logout
        Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()
        
        // TODO: Clear user session data (SharedPreferences, tokens, etc.)
        
        // Navigate back to MainActivity (login/register screen)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
    
    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    
    private fun navigateToMyCharger() {
        val intent = Intent(this, MyChargerActivity::class.java)
        startActivity(intent)
    }
}
