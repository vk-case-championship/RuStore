package ru.rchudinov.rustore.activities

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import ru.rchudinov.rustore.R
import java.io.IOException

class StartOnboardingActivity :  AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        imageView = findViewById(R.id.imageView4)
        showMascot("mascot.png")
        val layout : ConstraintLayout = findViewById(R.id.onboarding1)
        layout.setOnClickListener {
            startActivity(Intent(this, Onboarding2Activity::class.java))
        }
    }

    private fun showMascot(fileName: String) {
        val assetManager = assets
        try {
            val inputStream = assetManager.open("images/$fileName")
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageView.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}