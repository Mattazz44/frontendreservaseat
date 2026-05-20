package com.example.reservaseat

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Sembunyikan ActionBar agar UI lebih bersih
        supportActionBar?.hide()

        // Inisialisasi semua View
        val etLoginPassword = findViewById<EditText>(R.id.etLoginPassword)
        val ivShowPassword = findViewById<ImageView>(R.id.ivShowPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)
        val tvGoToRegister = findViewById<TextView>(R.id.tvGoToRegister)

        // 1. Logika Tombol Lihat Password (Ikon Mata)
        ivShowPassword.setOnClickListener {
            if (isPasswordVisible) {
                // Sembunyikan password
                etLoginPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                ivShowPassword.setImageResource(android.R.drawable.ic_menu_view)
                isPasswordVisible = false
            } else {
                // Tampilkan password
                etLoginPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                ivShowPassword.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                isPasswordVisible = true
            }
            // Pindahkan kursor ke posisi paling belakang teks
            etLoginPassword.setSelection(etLoginPassword.text.length)
        }

        // 2. Logika Tombol Sign In - Navigasi ke MainActivity
        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() 
        }

        // 3. Logika Teks Lupa Password
        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Fitur Lupa Password segera hadir", Toast.LENGTH_SHORT).show()
        }

        // 4. Logika Teks Belum Punya Akun - Navigasi ke RegisterActivity
        tvGoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
