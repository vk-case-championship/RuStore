package ru.rchudinov.rustore.activities

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import ru.rchudinov.rustore.R
import java.io.IOException

class Onboarding3Activity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gos)
        enableEdgeToEdge()

        imageView = findViewById(R.id.imageView5)
        showMascot("mascot.png")

        var frameLayout: FrameLayout = findViewById(R.id.dimScreen2)
        frameLayout.visibility = View.VISIBLE
        val layout : ConstraintLayout = findViewById(R.id.gos_main)
        layout.setOnClickListener {
            frameLayout.visibility = View.GONE
            startActivity(Intent(this, GamesActivity::class.java))
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