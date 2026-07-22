package com.arizonrp.launcher.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.launcher.R

class SplashActivity : AppCompatActivity() {
    private var currentProgress = 10
    private lateinit var progressBar: ProgressBar
    private lateinit var percentLabel: TextView
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progress_bar_fill)
        percentLabel = findViewById(R.id.percent_label)
        handler = Handler(Looper.getMainLooper())

        startProgressSimulation()
    }

    private fun startProgressSimulation() {
        handler.postDelayed({
            updateProgress()
        }, 1500)
    }

    private fun updateProgress() {
        if (currentProgress < 100) {
            val increment = (Math.random() * 2).toInt()
            currentProgress = minOf(100, currentProgress + increment)

            progressBar.progress = currentProgress
            percentLabel.text = "$currentProgress%"

            val delay = (Math.random() * 500 + 100).toLong()
            handler.postDelayed({
                updateProgress()
            }, delay)
        } else {
            percentLabel.text = "جاهز!"
            handler.postDelayed({
                navigateToMain()
            }, 500)
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}