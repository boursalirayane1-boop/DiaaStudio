package com.arizonrp.launcher.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.launcher.R

class MainActivity : AppCompatActivity() {
    private var currentTab = "home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        val settingsTab = findViewById<LinearLayout>(R.id.tab_settings)
        val homeTab = findViewById<LinearLayout>(R.id.tab_home)
        val profileTab = findViewById<LinearLayout>(R.id.tab_profile)

        settingsTab.setOnClickListener {
            if (currentTab != "settings") {
                currentTab = "settings"
                startActivity(android.content.Intent(this, SettingsActivity::class.java))
            }
        }

        homeTab.setOnClickListener {
            currentTab = "home"
        }

        profileTab.setOnClickListener {
            if (currentTab != "profile") {
                currentTab = "profile"
                startActivity(android.content.Intent(this, ProfileActivity::class.java))
            }
        }
    }
}