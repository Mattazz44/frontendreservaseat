package com.example.reservaseat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Sembunyikan ActionBar bawaan
        supportActionBar?.hide()

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnEditPhoto = findViewById<ImageView>(R.id.btnEditPhoto)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Fungsi tombol back kembali ke halaman sebelumnya
        btnBack.setOnClickListener { finish() }

        // Fungsi klik ganti foto profil
        btnEditPhoto.setBounceClick {
            Toast.makeText(this, "Pilih foto dari galeri...", Toast.LENGTH_SHORT).show()
        }

        // Fungsi klik save
        btnSave.setBounceClick {
            Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show()
            finish() // Opsional: tutup halaman setelah save
        }
    }

    // Fungsi tambahan buat efek animasi mencet tombol
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