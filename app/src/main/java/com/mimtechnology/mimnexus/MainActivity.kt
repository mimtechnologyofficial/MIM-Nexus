package com.mimtechnology.mimnexus

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(10, 10, 10))
            setPadding(32, 32, 32, 32)
        }

        val header = TextView(this).apply {
            text = "MIM Nexus"
            textSize = 28f
            setTextColor(Color.WHITE)
            setTypeface(null, Typeface.BOLD)
            setPadding(0, 20, 0, 20)
        }

        val welcome = TextView(this).apply {
            text = "Selamat datang 👋"
            textSize = 22f
            setTextColor(Color.WHITE)
            setPadding(0, 30, 0, 10)
        }

        val subtitle = TextView(this).apply {
            text = "Ruang kerja digital MIM Nexus"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            setPadding(0, 0, 0, 30)
        }

        val nexus = TextView(this).apply {
            text = "MIM NEXUS"
            textSize = 30f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setTypeface(null, Typeface.BOLD)
            setBackgroundColor(Color.rgb(30, 30, 30))
            setPadding(20, 60, 20, 60)
        }

        val project = TextView(this).apply {
            text = "📁  Projek"
            textSize = 18f
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.rgb(35, 35, 35))
            setPadding(30, 35, 30, 35)

            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Menu Projek MIM Nexus",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val tools = TextView(this).apply {
            text = "🛠️  Tools"
            textSize = 18f
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.rgb(35, 35, 35))
            setPadding(30, 35, 30, 35)

            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Menu Tools MIM Nexus",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        root.addView(header)
        root.addView(welcome)
        root.addView(subtitle)

        root.addView(
            nexus,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        root.addView(
            project,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 30, 0, 15)
            }
        )

        root.addView(
            tools,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )

        setContentView(root)
    }
}
