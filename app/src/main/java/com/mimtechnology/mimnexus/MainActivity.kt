package com.mimtechnology.mimnexus

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.*
import android.view.ViewGroup

class MainActivity : Activity() {

    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(10, 10, 10))
            setPadding(28, 28, 28, 28)
        }

        val title = TextView(this).apply {
            text = "MIM Nexus"
            textSize = 30f
            setTextColor(Color.WHITE)
            setTypeface(null, Typeface.BOLD)
        }

        val subtitle = TextView(this).apply {
            text = "Ruang kerja digital MIM Nexus"
            textSize = 17f
            setTextColor(Color.LTGRAY)
            setPadding(0, 8, 0, 25)
        }

        val banner = TextView(this).apply {
            text = "MIM NEXUS"
            textSize = 28f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setTypeface(null, Typeface.BOLD)
            setBackgroundColor(Color.rgb(30, 30, 30))
            setPadding(10, 45, 10, 45)
        }

        status = TextView(this).apply {
            text = "Status: Siap digunakan"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            setPadding(5, 20, 5, 20)
        }

        val biosButton = makeButton("📦  Import BIOS PS2")
        biosButton.setOnClickListener {
            openFile("BIOS")
        }

        val gameButton = makeButton("🎮  Import Game")
        gameButton.setOnClickListener {
            openFile("GAME")
        }

        val settingsButton = makeButton("⚙️  Pengaturan")
        settingsButton.setOnClickListener {
            Toast.makeText(
                this,
                "Pengaturan MIM Nexus",
                Toast.LENGTH_SHORT
            ).show()
        }

        val info = TextView(this).apply {
            text = "BIOS dan game dipilih dari penyimpanan HP."
            textSize = 14f
            setTextColor(Color.GRAY)
            setPadding(5, 20, 5, 5)
        }

        root.addView(title)
        root.addView(subtitle)
        root.addView(banner)

        root.addView(
            status,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        root.addView(biosButton)
        root.addView(gameButton)
        root.addView(settingsButton)
        root.addView(info)

        setContentView(root)
    }

    private fun makeButton(textValue: String): TextView {
        return TextView(this).apply {
            text = textValue
            textSize = 18f
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.rgb(35, 35, 35))
            setPadding(25, 35, 25, 35)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(0, 8, 0, 8)
            layoutParams = params
        }
    }

    private fun openFile(type: String) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"
        }

        startActivityForResult(intent, if (type == "BIOS") 100 else 200)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val uri: Uri? = data?.data

            if (requestCode == 100) {
                status.text = "Status: BIOS PS2 sudah dipilih ✅"
                Toast.makeText(
                    this,
                    "BIOS berhasil dipilih",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (requestCode == 200) {
                status.text = "Status: Game sudah dipilih 🎮"
                Toast.makeText(
                    this,
                    "Game berhasil dipilih",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
