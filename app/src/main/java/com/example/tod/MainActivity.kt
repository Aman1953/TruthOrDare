package com.example.tod

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottleImage: ImageView = findViewById(R.id.imageView)
        val spinButton: Button = findViewById(R.id.button)

        spinButton.setOnClickListener {
            spinBottle(bottleImage)
        }
    }

    private fun spinBottle(bottle: ImageView) {
        // Generate a random rotation angle between 720 and 2880 degrees (2-8 full spins)
        val randomAngle = Random.nextInt(720, 2880)

        // Create the rotation animation
        val rotateAnimator = ObjectAnimator.ofFloat(bottle, "rotation", 0f, randomAngle.toFloat())
        rotateAnimator.duration = 2000 // Set animation duration to 2 seconds
        rotateAnimator.interpolator = AccelerateDecelerateInterpolator() // Smooth start and end

        rotateAnimator.start()
    }
}
