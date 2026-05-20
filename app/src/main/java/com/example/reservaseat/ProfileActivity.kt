package com.example.reservaseat // Sesuaikan package lu

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Sembunyikan ActionBar atas
        supportActionBar?.hide()

        // Deklarasi tombol
        val btnEditProfile = findViewById<LinearLayout>(R.id.btnEditProfile)
        val btnAddresses = findViewById<LinearLayout>(R.id.btnAddresses)
        val btnFavourite = findViewById<LinearLayout>(R.id.btnFavourite)
        val btnNotifications = findViewById<LinearLayout>(R.id.btnNotifications)
        val btnLogOut = findViewById<LinearLayout>(R.id.btnLogOut)

        // Set animasi klik & Toast untuk simulasi
        btnEditProfile.setBounceClick { showToast("Edit Profile clicked") }
        btnAddresses.setBounceClick { showToast("Addresses clicked") }
        btnFavourite.setBounceClick { showToast("Favourite clicked") }
        btnNotifications.setBounceClick { showToast("Notifications clicked") }
        btnLogOut.setBounceClick {
            showToast("Logging Out...")
            // Tambahkan logika logout di sini
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Ekstensi untuk animasi klik "mantul"
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