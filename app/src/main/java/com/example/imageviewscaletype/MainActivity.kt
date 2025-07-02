package com.example.imageviewscaletype

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imageviewscaletype.databinding.ActivityMainBinding
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {

    var isImageChanged = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*Click Events*/
        initUI()
    }

    private fun initUI() {
        binding.userImageNone.setOnClickListener {
            changeImage(binding.userImageNone)
        }

        binding.userImageCenter.setOnClickListener {
            changeImage(binding.userImageCenter)
        }

        binding.userImageCenterCrop.setOnClickListener {
            changeImage(binding.userImageCenterCrop)
        }

        binding.userImageCenterInside.setOnClickListener {
            changeImage(binding.userImageCenterInside)
        }

        binding.userImageMatrix.setOnClickListener {
            changeImage(binding.userImageMatrix)
        }

        binding.userImageFitCenter.setOnClickListener {
            changeImage(binding.userImageFitCenter)
        }

        binding.userImageFitEnd.setOnClickListener {
            changeImage(binding.userImageFitEnd)
        }

        binding.userImageFitXY.setOnClickListener {
            changeImage(binding.userImageFitXY)
        }

        binding.userImageFitStart.setOnClickListener {
            changeImage(binding.userImageFitStart)
        }
    }

    fun changeImage(imageView: ShapeableImageView) {
        if (isImageChanged) {
            imageView.setImageResource(R.drawable.image_test) // original image
        } else {
            imageView.setImageResource(R.drawable.image_test_horizontal) // new image
        }
        isImageChanged = !isImageChanged
    }
}