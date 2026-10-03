package com.mimtechnology.mimnexus

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = TextView(this).apply {
            text = "MIM Nexus"
            textSize = 32f
            gravity = android.view.Gravity.CENTER
        }

        setContentView(title)
    }
}
