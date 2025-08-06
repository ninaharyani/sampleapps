package com.example.ninaa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = UserDatabaseHelper( this)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnlogin = findViewById<Button>(R.id.btnLogin)

        btnlogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(, "this", "Harap isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val isvalid = dbHelper.checkUser(username, password)
            if (IsValid) {
                Toast.makeText(, "this", "login berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity ::class.java )

                intent.putExtra("username", username) // kirim data username
                startActivity(intent)
                // tutup LoginActivity agar tidak bisa balik pakai tombol back
                finish()
            } else {
                Toast.makeText(, "this", "login gagal : user tidak ditemukan", Toast.LENGTH_SHORT).show()
            }

        }


    }


}