package com.example.reservaseat // Ganti sesuai package lu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IsiDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_data_botas)
        supportActionBar?.hide()

        // Deklarasi EditText
        val etNama = findViewById<EditText>(R.id.etNama)
        val etTelepon = findViewById<EditText>(R.id.etTelepon)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPerihal = findViewById<EditText>(R.id.etPerihal)
        val etNota = findViewById<EditText>(R.id.etNota)

        // Tombol Navigasi Kembali
        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            // Ambil data dari inputan
            val nama = etNama.text.toString().trim()
            val telepon = etTelepon.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val perihal = etPerihal.text.toString().trim()
            val nota = etNota.text.toString().trim()

            // Validasi sederhana: Pastikan field penting nggak kosong
            if (nama.isEmpty() || telepon.isEmpty() || email.isEmpty() || perihal.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi data yang wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                // Logic untuk lanjut ke halaman selanjutnya atau memproses pembayaran
                Toast.makeText(this, "Data tersimpan! Lanjut ke pembayaran...", Toast.LENGTH_SHORT).show()

                // Contoh pindah halaman:
                // val intent = Intent(this, PembayaranActivity::class.java)
                // startActivity(intent)
            }
        }
    }
}