package com.example.reservaseat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PembayaranStatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran_status_berhasil_botas)

        // Sembunyikan ActionBar bawaan
        supportActionBar?.hide()

        val btnBackHeader = findViewById<ImageView>(R.id.btnBackHeader)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        // Fungsi klik tombol back di pojok kiri atas
        btnBackHeader.setOnClickListener {
            finish()
        }

        // Fungsi klik tombol "Kembali" warna hijau di bawah
        btnKembali.setBounceClick {
            // Karena ini halaman sukses pembayaran, biasanya "Kembali"
            // akan membawa user ke halaman utama/Home.

            // Contoh jika ingin pindah ke HomeActivity:
            // val intent = Intent(this, HomeActivity::class.java)
            // intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            // startActivity(intent)

            // Atau cukup finish() untuk menutup halaman ini
            finish()
        }
    }

    // Extension Function untuk animasi klik mantul
    private fun View.setBounceClick(onAction: () -> Unit) {
        this.setOnClickListener {
            this.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction {
                    this.animate()
                        .scaleX(1.0f)
                        .scaleY(1.0f)
                        .setDuration(100)
                        .withEndAction { onAction() }
                        .start()
                }
                .start()
        }
    }
}