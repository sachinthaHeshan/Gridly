package com.example.gridly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingFragment : Fragment() {
    
    private var imageResId: Int = 0
    private var title: String = ""
    private var description: String = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(ARG_IMAGE_RES_ID)
            title = it.getString(ARG_TITLE) ?: ""
            description = it.getString(ARG_DESCRIPTION) ?: ""
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val imageView = view.findViewById<ImageView>(R.id.onboarding_image)
        val titleTextView = view.findViewById<TextView>(R.id.onboarding_title)
        val descriptionTextView = view.findViewById<TextView>(R.id.onboarding_description)
        
        imageView.setImageResource(imageResId)
        titleTextView.text = title
        descriptionTextView.text = description
    }
    
    companion object {
        private const val ARG_IMAGE_RES_ID = "image_res_id"
        private const val ARG_TITLE = "title"
        private const val ARG_DESCRIPTION = "description"
        
        fun newInstance(imageResId: Int, title: String, description: String): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle().apply {
                putInt(ARG_IMAGE_RES_ID, imageResId)
                putString(ARG_TITLE, title)
                putString(ARG_DESCRIPTION, description)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
