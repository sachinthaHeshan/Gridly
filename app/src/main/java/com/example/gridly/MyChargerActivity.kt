package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MyChargerActivity : AppCompatActivity() {
    
    private lateinit var navHome: ImageView
    private lateinit var navProfile: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_charger)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        navHome = findViewById(R.id.nav_home)
        navProfile = findViewById(R.id.nav_profile)
    }
    
    private fun setupClickListeners() {
        navHome.setOnClickListener {
            navigateToHome()
        }
        
        navProfile.setOnClickListener {
            navigateToProfile()
        }
    }
    
    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    
    private fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}
