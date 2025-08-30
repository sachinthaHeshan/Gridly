package com.example.gridly

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        
        // Disable page change animations
        viewPager.setPageTransformer(null)
        viewPager.isUserInputEnabled = true
        // Remove any default page transformer animations by reducing animation duration
        try {
            val field = ViewPager2::class.java.getDeclaredField("mRecyclerView")
            field.isAccessible = true
            val recyclerView = field.get(viewPager) as androidx.recyclerview.widget.RecyclerView
            recyclerView.overScrollMode = androidx.recyclerview.widget.RecyclerView.OVER_SCROLL_NEVER
        } catch (e: Exception) {
            // If reflection fails, continue without additional optimizations
        }
    }
    
    private fun setupClickListeners() {
        skipButton.setOnClickListener {
            navigateToMain()
        }
        
        nextButton.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                // Disable smooth scrolling animation for instant page change
                viewPager.setCurrentItem(viewPager.currentItem + 1, false)
            } else {
                navigateToMain()
            }
        }
    }
    
    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
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
