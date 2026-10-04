package com.mimtechnology.mimnexus

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(8, 8, 10))
            setPadding(28, 32, 28, 28)
        }

        val title = TextView(this).apply {
            text = "MIM Nexus"
            textSize = 30f
            setTextColor(Color.WHITE)
            setTypeface(null, Typeface.BOLD)
        }

        val subtitle = TextView(this).apply {
            text = "Ruang kerja digital MIM Technology"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            setPadding(0, 8, 0, 24)
        }

        val banner = TextView(this).apply {
            text = "MIM NEXUS"
            textSize = 28f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setTypeface(null, Typeface.BOLD)
            setBackgroundColor(Color.rgb(28, 28, 32))
            setPadding(10, 55, 10, 55)
        }

        root.addView(title)
        root.addView(subtitle)

        root.addView(
            banner,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 20)
            }
        )

        status = TextView(this).apply {
            text = "●  Status: Siap digunakan"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            setPadding(5, 10, 5, 20)
        }

        root.addView(status)

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
            text = "Pilih BIOS dan game dari penyimpanan HP."
            textSize = 14f
            setTextColor(Color.GRAY)
            setPadding(5, 20, 5, 5)
        }

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
            gravity = Gravity.CENTER_VERTICAL
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.rgb(35, 35, 40))
            setPadding(25, 32, 25, 32)

            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 8, 0, 8)
            }
        }
    }

    private fun openFile(type: String) {

        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            this.type = "*/*"
        }

        val requestCode = if (type == "BIOS") 100 else 200

        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != RESULT_OK) {
            return
        }

        val uri: Uri? = data?.data

        if (uri == null) {
            return
        }

        if (requestCode == 100) {
            status.text = "●  BIOS PS2 berhasil dipilih ✅"

            Toast.makeText(
                this,
                "BIOS berhasil dipilih",
                Toast.LENGTH_SHORT
            ).show()
        }

        if (requestCode == 200) {
            status.text = "●  Game berhasil dipilih 🎮"

            Toast.makeText(
                this,
                "Game berhasil dipilih",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
