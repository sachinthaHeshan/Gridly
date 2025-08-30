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

class MyChargerActivity : AppCompatActivity() {
    
    private lateinit var chargerImage: ImageView
    private lateinit var chargerName: TextView
    private lateinit var chargerStatus: TextView
    private lateinit var chargerPower: TextView
    private lateinit var chargerConnector: TextView
    private lateinit var chargerLocation: TextView
    private lateinit var startChargingButton: MaterialButton
    private lateinit var settingsButton: MaterialButton
    
    // Bottom Navigation
    private lateinit var navHome: ImageView
    private lateinit var navMap: ImageView
    private lateinit var navHistory: ImageView
    private lateinit var navProfile: ImageView
    private lateinit var navSettings: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_charger)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content_scroll)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        
        initViews()
        setupClickListeners()
        loadChargerData()
    }
    
    private fun initViews() {
        chargerImage = findViewById(R.id.charger_image)
        chargerName = findViewById(R.id.charger_name)
        chargerStatus = findViewById(R.id.charger_status)
        chargerPower = findViewById(R.id.charger_power)
        chargerConnector = findViewById(R.id.charger_connector)
        chargerLocation = findViewById(R.id.charger_location)
        startChargingButton = findViewById(R.id.start_charging_button)
        settingsButton = findViewById(R.id.settings_button)
        
        // Bottom Navigation
        navHome = findViewById(R.id.nav_home)
        navMap = findViewById(R.id.nav_map)
        navHistory = findViewById(R.id.nav_history)
        navProfile = findViewById(R.id.nav_profile)
        navSettings = findViewById(R.id.nav_settings)
    }
    
    private fun setupClickListeners() {
        startChargingButton.setOnClickListener {
            handleStartCharging()
        }
        
        settingsButton.setOnClickListener {
            handleSettings()
        }
        
        // Bottom Navigation Click Listeners
        navHome.setOnClickListener {
            navigateToHome()
        }
        
        navMap.setOnClickListener {
            navigateToMap()
        }
        
        navHistory.setOnClickListener {
            // Already on My Charger page - do nothing or refresh
        }
        
        navProfile.setOnClickListener {
            navigateToProfile()
        }
        
        navSettings.setOnClickListener {
            navigateToSettings()
        }
    }
    
    private fun loadChargerData() {
        // Load charger data (in a real app, this would come from a database or API)
        chargerName.text = "EV Fast Charger"
        chargerStatus.text = "Available"
        chargerPower.text = "22 kW"
        chargerConnector.text = "Type 2"
        chargerLocation.text = "Home Garage"
        
        // Set status color based on availability
        when (chargerStatus.text.toString().toLowerCase()) {
            "available" -> {
                chargerStatus.setTextColor(getColor(android.R.color.holo_green_light))
            }
            "in use" -> {
                chargerStatus.setTextColor(getColor(android.R.color.holo_orange_light))
            }
            "offline" -> {
                chargerStatus.setTextColor(getColor(android.R.color.holo_red_light))
            }
        }
    }
    
    private fun handleStartCharging() {
        when (chargerStatus.text.toString().toLowerCase()) {
            "available" -> {
                // Start charging process
                chargerStatus.text = "In Use"
                chargerStatus.setTextColor(getColor(android.R.color.holo_orange_light))
                startChargingButton.text = "Stop Charging"
                
                Toast.makeText(
                    this,
                    "Charging started successfully!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            "in use" -> {
                // Stop charging process
                chargerStatus.text = "Available"
                chargerStatus.setTextColor(getColor(android.R.color.holo_green_light))
                startChargingButton.text = "Start Charging"
                
                Toast.makeText(
                    this,
                    "Charging stopped successfully!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                Toast.makeText(
                    this,
                    "Charger is currently offline",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    
    private fun handleSettings() {
        // TODO: Navigate to charger settings page
        Toast.makeText(
            this,
            "Charger settings coming soon!",
            Toast.LENGTH_SHORT
        ).show()
    }
    
    // Bottom Navigation Methods
    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    
    private fun navigateToMap() {
        Toast.makeText(
            this,
            "Map view coming soon!",
            Toast.LENGTH_SHORT
        ).show()
    }
    
    private fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
    
    private fun navigateToSettings() {
        Toast.makeText(
            this,
            "Settings coming soon!",
            Toast.LENGTH_SHORT
        ).show()
    }
}
