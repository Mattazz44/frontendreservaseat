package com.example.reservaseat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PembayaranGagalBotas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran_gagal_botas)

        supportActionBar?.hide()

        val btnBackHeader = findViewById<ImageView>(R.id.btnBackHeader)
        val btnCobaLagi = findViewById<Button>(R.id.btnCobaLagi)

        btnBackHeader.setOnClickListener {
            finish()
        }

        // Fungsi klik tombol "Coba Lagi"
        btnCobaLagi.setBounceClick {
            Toast.makeText(this, "Mengalihkan ke metode pembayaran...", Toast.LENGTH_SHORT).show()
            finish() // Menutup halaman ini agar user kembali ke form input data/pembayaran sebelumnya
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