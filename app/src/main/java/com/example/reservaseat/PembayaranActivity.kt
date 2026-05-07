package com.example.reservaseat // Sesuaikan package lu

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PembayaranActivity : AppCompatActivity() {

    private var selectedPaymentMethod: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran_botas)
        supportActionBar?.hide()

        // (Opsional) Ambil data dari Intent yang dikirim dari IsiDataActivity
        /*
        val nama = intent.getStringExtra("NAMA_PEMESAN") ?: "Adit Chunns"
        val telepon = intent.getStringExtra("NO_TELP") ?: "081234567890"
        val email = intent.getStringExtra("EMAIL") ?: "adit@email.com"

        findViewById<TextView>(R.id.tvSummaryNama).text = nama
        findViewById<TextView>(R.id.tvSummaryTelepon).text = telepon
        findViewById<TextView>(R.id.tvSummaryEmail).text = email
        */

        // Definisi Layout Metode Pembayaran
        val btnQris = findViewById<RelativeLayout>(R.id.btnPayQris)
        val btnDana = findViewById<RelativeLayout>(R.id.btnPayDana)
        val btnOvo = findViewById<RelativeLayout>(R.id.btnPayOvo)
        val btnGopay = findViewById<RelativeLayout>(R.id.btnPayGopay)

        val allPaymentBtns = listOf(btnQris, btnDana, btnOvo, btnGopay)

        // Fungsi klik untuk milih metode pembayaran
        fun selectPayment(selectedBtn: RelativeLayout, method: String) {
            // Reset background semua jadi transparan/putih lagi
            allPaymentBtns.forEach { it.setBackgroundColor(Color.TRANSPARENT) }
            // Highlight yang dipilih jadi abu-abu muda (kayak contoh DANA di gambar)
            selectedBtn.setBackgroundColor(Color.parseColor("#F8F8F8"))
            selectedPaymentMethod = method
        }

        btnQris.setOnClickListener { selectPayment(btnQris, "QRIS") }
        btnDana.setOnClickListener { selectPayment(btnDana, "DANA") }
        btnOvo.setOnClickListener { selectPayment(btnOvo, "OVO") }
        btnGopay.setOnClickListener { selectPayment(btnGopay, "GOPAY") }

        // Tombol Kembali
        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            if (selectedPaymentMethod.isEmpty()) {
                Toast.makeText(this, "Silakan pilih metode pembayaran terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Melanjutkan pembayaran dengan $selectedPaymentMethod...", Toast.LENGTH_SHORT).show()
                // Pindah ke halaman Sukses / Konfirmasi akhir
            }
        }
    }
}