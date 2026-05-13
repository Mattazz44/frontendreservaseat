package com.example.reservaseat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class PilihCabangActivity : AppCompatActivity() {

    private var selectedCabang: String? = null // "BOTAS" atau "JAMBU_DUA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_cabang)
        supportActionBar?.hide()

        val btnBackHeader = findViewById<ImageView>(R.id.btnBackHeader)
        val btnKembali = findViewById<Button>(R.id.btnKembali)
        val btnLanjutkan = findViewById<Button>(R.id.btnLanjutkan)
        val cardBotas = findViewById<CardView>(R.id.cardBotas)
        val cardJambuDua = findViewById<CardView>(R.id.cardJambuDua)

        btnBackHeader.setOnClickListener { finish() }
        btnKembali.setOnClickListener { finish() }

        cardBotas.setOnClickListener {
            selectedCabang = "BOTAS"
            cardBotas.cardElevation = 12f
            cardJambuDua.cardElevation = 3f
            Toast.makeText(this, "Cabang Botani Square dipilih", Toast.LENGTH_SHORT).show()
        }

        cardJambuDua.setOnClickListener {
            selectedCabang = "JAMBU_DUA"
            cardJambuDua.cardElevation = 12f
            cardBotas.cardElevation = 3f
            Toast.makeText(this, "Cabang Jambu Dua dipilih", Toast.LENGTH_SHORT).show()
        }

        btnLanjutkan.setOnClickListener {
            when (selectedCabang) {
                "BOTAS" -> startActivity(Intent(this, PilihTanggalActivity::class.java))
                "JAMBU_DUA" -> startActivity(Intent(this, PilihTanggalActivity2::class.java))
                else -> Toast.makeText(this, "Silakan pilih cabang terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
