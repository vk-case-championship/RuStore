package ru.rchudinov.rustore.activities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ru.rchudinov.rustore.R
import java.io.IOException

class GosActivity: AppCompatActivity() {
    private lateinit var dimScreen: FrameLayout
    private lateinit var screenImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gos)
        enableEdgeToEdge()
        val screen1: ImageView = findViewById(R.id.image1)
        val screen2: ImageView = findViewById(R.id.image2)
        val screen3: ImageView = findViewById(R.id.image3)
        dimScreen = findViewById(R.id.dimScreen)
        screenImageView = findViewById(R.id.dimView)

        loadImageFromAssets(screen1, "screen_1.png")
        loadImageFromAssets(screen2, "screen_2.png")
        loadImageFromAssets(screen3, "screen_3.png")

        screen1.setOnClickListener {
            showScreenshot("screen_1_quality.png")
        }
        screen2.setOnClickListener {
            showScreenshot("screen_2_quality.png")
        }
        screen3.setOnClickListener {
            showScreenshot("screen_3_quality.png")
        }

        dimScreen.setOnClickListener {
            hideScreenshot()
        }
    }

    fun loadImageFromAssets(imageView: ImageView, fileName: String) {
        val assetManager = assets
        try {
            val inputStream = assetManager.open("images/$fileName")
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageView.setImageBitmap(bitmap)
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun showScreenshot(fileName: String) {
        val assetManager = assets
        try {
            val inputStream = assetManager.open("images/$fileName")
            val bitmap = BitmapFactory.decodeStream(inputStream)
            screenImageView.setImageBitmap(bitmap)

            dimScreen.visibility = View.VISIBLE
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun hideScreenshot() {
        dimScreen.visibility = View.GONE
        screenImageView.setImageBitmap(null)
    }
}