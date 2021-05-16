package com.duckbuddyy.movtime.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duckbuddyy.movtime.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Changing Splash Screen Theme to Application's Theme
        setTheme(R.style.Theme_MovTime)
        setContentView(R.layout.activity_main)
    }
}