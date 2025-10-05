package ru.rchudinov.rustore.activities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import ru.rchudinov.rustore.R
import java.io.IOException

class Onboarding2Activity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apps_main)
        imageView = findViewById(R.id.imageView4)
        showMascot("mascot.png")

        val frameLayout: FrameLayout = findViewById(R.id.dimScreen)
        frameLayout.visibility = View.VISIBLE
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