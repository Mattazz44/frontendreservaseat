package com.example.reservaseat

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        val tvGoToLogin = findViewById<TextView>(R.id.tvGoToLogin)

        // Membuat teks "Sign in" menjadi warna hijau sesuai desain
        val text = "Sudah punya akun? Sign in"
        val spannableString = SpannableString(text)
        val greenColor = Color.parseColor("#6A9B6B") // Warna hijau muda untuk teks link

        spannableString.setSpan(
            ForegroundColorSpan(greenColor),
            18,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvGoToLogin.text = spannableString

        tvGoToLogin.setOnClickListener {
            // Kembali ke halaman Login (menutup activity register)
            finish()
        }
    }
}