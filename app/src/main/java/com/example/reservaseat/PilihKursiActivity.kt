package com.example.reservaseat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PilihKursiActivity : AppCompatActivity() {

    private var selectedSeat: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_kursi_botas)
        supportActionBar?.hide()

        val seatIds = listOf(
            R.id.seatA, R.id.seatB, R.id.seatC, R.id.seatD, R.id.seatE,
            R.id.seatF, R.id.seatG, R.id.seatH, R.id.seatI, R.id.seatJ,
            R.id.seatK, R.id.seatL, R.id.seatM, R.id.seatN, R.id.seatO
        )

        for (id in seatIds) {
            val seatView = findViewById<TextView>(id)
            seatView.setOnClickListener { view ->
                val clickedSeat = view as TextView
                if (clickedSeat == selectedSeat) {
                    resetSeat(clickedSeat)
                    selectedSeat = null
                } else {
                    selectedSeat?.let { resetSeat(it) }
                    clickedSeat.setBackgroundResource(R.drawable.bg_seat_selected)
                    clickedSeat.setTextColor(Color.WHITE)
                    selectedSeat = clickedSeat
                }
            }
        }

        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan — navigasi ke IsiDataActivity
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            if (selectedSeat == null) {
                Toast.makeText(this, "Silakan pilih kursi terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, IsiDataActivity::class.java)
                intent.putExtra("KURSI", selectedSeat?.text?.toString())
                startActivity(intent)
            }
        }
    }

    private fun resetSeat(seat: TextView) {
        seat.setBackgroundResource(R.drawable.bg_seat_unselected)
        seat.setTextColor(Color.BLACK)
    }
}
