package com.example.reservaseat

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PilihKursiActivity : AppCompatActivity() {

    // Variable buat nyimpen kursi mana yang lagi dipilih
    private var selectedSeat: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_kursi_botas)
        supportActionBar?.hide()

        // Daftarkan semua ID kursi
        val seatIds = listOf(
            R.id.seatA, R.id.seatB, R.id.seatC, R.id.seatD, R.id.seatE,
            R.id.seatF, R.id.seatG, R.id.seatH, R.id.seatI, R.id.seatJ,
            R.id.seatK, R.id.seatL, R.id.seatM, R.id.seatN, R.id.seatO
        )

        // Loop untuk ngasih aksi "Klik / Hover" ke semua kursi
        for (id in seatIds) {
            val seatView = findViewById<TextView>(id)
            seatView.setOnClickListener { view ->
                val clickedSeat = view as TextView

                // Kalau kursi yang di-klik udah terpilih, batalin pilihannya
                if (clickedSeat == selectedSeat) {
                    resetSeat(clickedSeat)
                    selectedSeat = null
                } else {
                    // Kalau ada kursi lain yang lagi dipilih, reset dulu warnanya
                    selectedSeat?.let { resetSeat(it) }

                    // Bikin kursi yang baru diklik jadi hijau (Terpilih)
                    clickedSeat.setBackgroundResource(R.drawable.bg_seat_selected)
                    clickedSeat.setTextColor(Color.WHITE)

                    // Simpan kursi ini sebagai kursi terpilih
                    selectedSeat = clickedSeat
                }
            }
        }

        // Navigasi Balik
        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            val kursiTerpilih = selectedSeat?.text?.toString()
            if (kursiTerpilih != null) {
                // Logic kalo udah pilih kursi, pindah activity (Contoh)
                // val intent = Intent(this, CheckoutActivity::class.java)
                // intent.putExtra("KURSI", kursiTerpilih)
                // startActivity(intent)
            } else {
                // (Opsional) Kasih Toast/Alert kalau belum pilih kursi
            }
        }
    }

    // Fungsi kecil buat ngembaliin warna kursi jadi abu-abu normal
    private fun resetSeat(seat: TextView) {
        seat.setBackgroundResource(R.drawable.bg_seat_unselected)
        seat.setTextColor(Color.BLACK)
    }
}