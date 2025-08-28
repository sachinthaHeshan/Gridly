package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    
    private lateinit var logoImageView: ImageView
    private lateinit var loadingProgressBar: ProgressBar
    private lateinit var loadingText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        
        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        startLoadingAnimation()
        navigateToMainActivity()
    }
    
    private fun initViews() {
        logoImageView = findViewById(R.id.logo_image)
        loadingProgressBar = findViewById(R.id.loading_progress)
        loadingText = findViewById(R.id.loading_text)
    }
    
    private fun startLoadingAnimation() {
        // Fade in animation for logo
        val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        logoImageView.startAnimation(fadeIn)
        
        // Show loading elements with delay
        Handler(Looper.getMainLooper()).postDelayed({
            loadingProgressBar.visibility = View.VISIBLE
            loadingText.visibility = View.VISIBLE
            
            val slideUp = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
            loadingProgressBar.startAnimation(slideUp)
            loadingText.startAnimation(slideUp)
        }, 1000)
    }
    
    private fun navigateToMainActivity() {
        // Navigate to MainActivity after 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            
            // Add custom transition animation
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 3000)
    }
}
