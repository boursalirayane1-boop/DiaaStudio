package com.arizonrp.launcher.activities

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.launcher.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupSeekBars()
        setupNavigation()
    }

    private fun setupSeekBars() {
        val generalVolume = findViewById<SeekBar>(R.id.seek_general_volume)
        val musicVolume = findViewById<SeekBar>(R.id.seek_music_volume)
        val radioVolume = findViewById<SeekBar>(R.id.seek_radio_volume)

        generalVolume?.progress = 85
        musicVolume?.progress = 40
        radioVolume?.progress = 65
    }

    private fun setupNavigation() {
        val homeTab = findViewById<LinearLayout>(R.id.tab_home)
        val profileTab = findViewById<LinearLayout>(R.id.tab_profile)

        homeTab.setOnClickListener {
            startActivity(android.content.Intent(this, MainActivity::class.java))
        }

        profileTab.setOnClickListener {
            startActivity(android.content.Intent(this, ProfileActivity::class.java))
        }
    }
}