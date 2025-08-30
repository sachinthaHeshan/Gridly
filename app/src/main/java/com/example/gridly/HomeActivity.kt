package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    
    private lateinit var chargerNavButton: ImageView
    private lateinit var profileNavButton: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        chargerNavButton = findViewById(R.id.nav_charger)
        profileNavButton = findViewById(R.id.nav_profile)
    }
    
    private fun setupClickListeners() {
        chargerNavButton.setOnClickListener {
            val intent = Intent(this, MyChargerActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
        
        profileNavButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}
