package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    
    // Navigation bar buttons
    private lateinit var homeNavButton: ImageView
    private lateinit var mapNavButton: ImageView
    private lateinit var historyNavButton: ImageView // My Charger navigation
    private lateinit var profileNavButton: ImageView
    private lateinit var settingsNavButton: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        // Bottom navigation
        homeNavButton = findViewById(R.id.nav_home)
        mapNavButton = findViewById(R.id.nav_map)
        historyNavButton = findViewById(R.id.nav_history)
        profileNavButton = findViewById(R.id.nav_profile)
        settingsNavButton = findViewById(R.id.nav_settings)
    }
    
    private fun setupClickListeners() {
        // Bottom navigation listeners
        historyNavButton.setOnClickListener {
            val intent = Intent(this, MyChargerActivity::class.java)
            startActivity(intent)
        }
        
        profileNavButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }
}
