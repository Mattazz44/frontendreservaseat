package com.example.reservaseat

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PilihCabangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_cabang)

        // Sembunyikan ActionBar bawaan
        supportActionBar?.hide()

        // Tombol Back di Header Kiri Atas
        val btnBackHeader = findViewById<ImageView>(R.id.btnBackHeader)
        btnBackHeader.setOnClickListener {
            finish() // Menutup halaman dan kembali ke sebelumnya
        }

        // Tombol "Kembali" di bagian bawah
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        btnKembali.setOnClickListener {
            finish()
        }

        // Tombol "Lanjutkan"
        val btnLanjutkan = findViewById<Button>(R.id.btnLanjutkan)
        btnLanjutkan.setOnClickListener {
            // Nanti tambahin logic buat pindah ke halaman berikutnya di sini
            // val intent = Intent(this, HalamanSelanjutnya::class.java)
            // startActivity(intent)
        }
    }
}