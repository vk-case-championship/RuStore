package ru.rchudinov.rustore.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import ru.rchudinov.rustore.OnboardinChecker
import ru.rchudinov.rustore.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val checker = OnboardinChecker()
            val isFirstLaunch = checker.isFirstLaunch(this)
            println(isFirstLaunch)
            if (isFirstLaunch) {
                checker.saveFirstLaunch(this, false)
                startActivity(Intent(this, StartOnboardingActivity::class.java))
                finish()
            } else {
                //checker.saveFirstLaunch(this, true)
                startActivity(Intent(this, GamesActivity::class.java))
                finish()
            }
        }, 3000)
    }
}