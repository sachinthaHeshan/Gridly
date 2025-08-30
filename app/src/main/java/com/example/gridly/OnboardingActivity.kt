package com.example.gridly

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton


class OnboardingActivity : AppCompatActivity() {
    
    private lateinit var viewPager: ViewPager2
    private lateinit var skipButton: MaterialButton
    private lateinit var nextButton: MaterialButton
    private lateinit var adapter: OnboardingPagerAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.onboarding_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        initViews()
        setupViewPager()
        setupClickListeners()
    }
    
    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        skipButton = findViewById(R.id.skipButton)
        nextButton = findViewById(R.id.nextButton)
    }
    
    private fun setupViewPager() {
        adapter = OnboardingPagerAdapter(this)
        viewPager.adapter = adapter
        
        // Listen to page changes
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateUI(position)
            }
        })
    }
    
    private fun setupClickListeners() {
        skipButton.setOnClickListener {
            navigateToMainActivity()
        }
        
        nextButton.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                viewPager.currentItem += 1
            } else {
                navigateToMainActivity()
            }
        }
    }
    
    private fun updateUI(position: Int) {
        when (position) {
            adapter.itemCount - 1 -> {
                nextButton.text = "Get Started"
                skipButton.visibility = View.GONE
            }
            else -> {
                nextButton.text = "Next"
                skipButton.visibility = View.VISIBLE
            }
        }
    }
    
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
    
    private class OnboardingPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3
        
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> OnboardingFragment.newInstance(
                    R.drawable.onboarding_image1,
                    "Welcome to GRIDLY",
                    "Find, book, and share EV chargers across Sri Lanka."
                )
                1 -> OnboardingFragment.newInstance(
                    R.drawable.onboarding_image2,
                    "For EV Drivers",
                    "No more waiting or long drives. Easily find nearby chargers, book a time slot, and charge stress-free."
                )
                2 -> OnboardingFragment.newInstance(
                    R.drawable.onboarding_image3,
                    "For Charger Owners",
                    "Turn your charger into income. List your charger, set your fee, and start earning instantly."
                )
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }
    }
}
