package com.example.reservaseat // Sesuaikan package lu

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FeedbackActivity_botas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_botas)
        supportActionBar?.hide()

        // Fungsi Tombol Kembali
        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener {
            finish()
        }

        // --- SETUP DATA FEEDBACK 1 ---
        val feedback1 = findViewById<View>(R.id.feedback1)
        feedback1.findViewById<TextView>(R.id.tvNamaUser).text = "lo siento wilson"
        feedback1.findViewById<TextView>(R.id.tvKomentar).text = "Wilson... Los Siento Wilsonn... \uD83D\uDE22"
        // (Bintang 5 nyala semua, gak perlu diubah karena defaultnya nyala di XML)


        // --- SETUP DATA FEEDBACK 2 ---
        val feedback2 = findViewById<View>(R.id.feedback2)
        feedback2.findViewById<TextView>(R.id.tvNamaUser).text = "kendrick lamar"
        feedback2.findViewById<TextView>(R.id.tvKomentar).text = "hmmmm... Lettuce free \uD83E\uDD24"

        // Bintang ke-5 dimatiin biar jadi rating 4 (warna abu-abu)
        val star5_fb2 = feedback2.findViewById<ImageView>(R.id.star5)
        star5_fb2.setColorFilter(android.graphics.Color.parseColor("#E0E0E0")) // Bintang abu-abu
    }
}