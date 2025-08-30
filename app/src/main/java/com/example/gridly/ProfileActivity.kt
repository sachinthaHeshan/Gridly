package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {
    
    private lateinit var logoutButton: MaterialButton
    private lateinit var navHome: ImageView
    private lateinit var navCharger: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        logoutButton = findViewById(R.id.logout_button)
        navHome = findViewById(R.id.nav_home)
        navCharger = findViewById(R.id.nav_charger)
    }
    
    private fun setupClickListeners() {
        logoutButton.setOnClickListener {
            handleLogout()
        }
        
        navHome.setOnClickListener {
            navigateToHome()
        }
        
        navCharger.setOnClickListener {
            navigateToMyCharger()
        }
    }
    
    private fun handleLogout() {
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
