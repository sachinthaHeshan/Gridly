package com.example.gridly

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {
    
    private lateinit var notificationIcon: ImageView
    private lateinit var currentBalanceText: TextView
    private lateinit var rechargeButton: MaterialButton
    private lateinit var findChargersButton: MaterialButton
    
    // Navigation bar buttons
    private lateinit var homeNavButton: ImageView
    private lateinit var mapNavButton: ImageView
    private lateinit var historyNavButton: ImageView
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
        // Header elements
        notificationIcon = findViewById(R.id.notification_icon)
        
        // Balance section
        currentBalanceText = findViewById(R.id.current_balance_amount)
        rechargeButton = findViewById(R.id.recharge_button)
        
        // Public chargers section
        findChargersButton = findViewById(R.id.find_chargers_button)
        
        // Bottom navigation
        homeNavButton = findViewById(R.id.nav_home)
        mapNavButton = findViewById(R.id.nav_map)
        historyNavButton = findViewById(R.id.nav_history)
        profileNavButton = findViewById(R.id.nav_profile)
        settingsNavButton = findViewById(R.id.nav_settings)
        
        // Set current balance (this would come from API/database in real app)
        currentBalanceText.text = "LKR 6,400.00"
    }
    
    private fun setupClickListeners() {
        notificationIcon.setOnClickListener {
            // TODO: Open notifications screen
        }
        
        rechargeButton.setOnClickListener {
            // TODO: Open recharge/payment screen
        }
        
        findChargersButton.setOnClickListener {
            // TODO: Open map/search for chargers
        }
        
        // Bottom navigation listeners
        homeNavButton.setOnClickListener {
            // Already on home - do nothing
        }
        
        mapNavButton.setOnClickListener {
            // TODO: Navigate to map activity
        }
        
        historyNavButton.setOnClickListener {
            // TODO: Navigate to charging history
        }
        
        profileNavButton.setOnClickListener {
            // TODO: Navigate to user profile
        }
        
        settingsNavButton.setOnClickListener {
            // TODO: Navigate to settings
        }
    }
}
