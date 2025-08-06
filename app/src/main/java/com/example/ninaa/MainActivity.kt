package com.example.ninaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val btnlogout = findViewById<Button>(R.id.btnlogout)
        // Ambil username dari intent
        val username = intent.getStringExtra("username") ?: "user"
        tvWelcome.text = "Selamat Datang, $username"
        btnlogout.setOnClickListener{
            Toast.makeText(, "this","Berhasil Logout", Toast.LENGTH_SHORT).show()

            //Kembali ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // Tutup MainActivity agar tidak bisa kembali dengan tombol back
            finish()
        }
    }
}