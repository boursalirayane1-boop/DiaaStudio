package com.arizonrp.launcher.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.launcher.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupNavigation()
    }

    private fun setupNavigation() {
        val settingsTab = findViewById<LinearLayout>(R.id.tab_settings)
        val homeTab = findViewById<LinearLayout>(R.id.tab_home)

        settingsTab.setOnClickListener {
            startActivity(android.content.Intent(this, SettingsActivity::class.java))
        }

        homeTab.setOnClickListener {
            startActivity(android.content.Intent(this, MainActivity::class.java))
        }
    }
}