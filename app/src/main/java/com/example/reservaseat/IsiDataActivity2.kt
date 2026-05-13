package com.example.reservaseat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IsiDataActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_data_jambu_dua)
        supportActionBar?.hide()

        val etNama = findViewById<EditText>(R.id.etNama)
        val etTelepon = findViewById<EditText>(R.id.etTelepon)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPerihal = findViewById<EditText>(R.id.etPerihal)
        val etNota = findViewById<EditText>(R.id.etNota)

        // Terima data kursi dari PilihKursiActivity2
        val kursiTerpilih = intent.getStringExtra("KURSI") ?: ""

        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan — navigasi ke PembayaranActivity2
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            val nama = etNama.text.toString().trim()
            val telepon = etTelepon.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val perihal = etPerihal.text.toString().trim()
            val nota = etNota.text.toString().trim()

            if (nama.isEmpty() || telepon.isEmpty() || email.isEmpty() || perihal.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi data yang wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, PembayaranActivity2::class.java)
                intent.putExtra("NAMA_PEMESAN", nama)
                intent.putExtra("NO_TELP", telepon)
                intent.putExtra("EMAIL", email)
                intent.putExtra("KURSI", kursiTerpilih)
                startActivity(intent)
            }
        }
    }
}
