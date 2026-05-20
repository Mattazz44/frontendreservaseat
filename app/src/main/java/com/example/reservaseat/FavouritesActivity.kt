package com.your.package.name

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FavouritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        // Sembunyikan ActionBar jika ada
        supportActionBar?.hide()

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnReserve1 = findViewById<Button>(R.id.btnReserve1)
        val btnReserve2 = findViewById<Button>(R.id.btnReserve2)
        val btnTambah = findViewById<Button>(R.id.btnTambah)

        btnBack.setOnClickListener { finish() }

        // Menerapkan animasi pada setiap tombol
        btnReserve1.setBounceClick {
            Toast.makeText(this, "Mereservasi Botani Square", Toast.LENGTH_SHORT).show()
        }

        btnReserve2.setBounceClick {
            Toast.makeText(this, "Mereservasi Bogor Trade Mall", Toast.LENGTH_SHORT).show()
        }

        btnTambah.setBounceClick {
            Toast.makeText(this, "Halaman Tambah Favorit", Toast.LENGTH_SHORT).show()
        }
    }

    // Extension Function untuk animasi mantul
    private fun View.setBounceClick(onAction: () -> Unit) {
        this.setOnClickListener {
            this.animate()
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(100)
                .withEndAction {
                    this.animate()
                        .scaleX(1.0f)
                        .scaleY(1.0f)
                        .setDuration(100)
                        .withEndAction {
                            onAction()
                        }
                        .start()
                }
                .start()
        }
    }
}