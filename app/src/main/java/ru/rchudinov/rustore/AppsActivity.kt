package ru.rchudinov.rustore

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AppsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apps_main)
        enableEdgeToEdge()
        val gosView: ImageView = findViewById(R.id.gos_uslugi)
        val imageView: ImageView = findViewById(R.id.games_icon)
        imageView.setOnClickListener {
            val intent = Intent(this, GamesActivity::class.java)
            startActivity(intent)
        }
        gosView.setOnClickListener {
            val intent = Intent(this, GosActivity::class.java)
            startActivity(intent)
        }

    }
}