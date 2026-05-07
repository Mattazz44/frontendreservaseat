package com.example.reservaseat

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PilihTanggalActivity2 : AppCompatActivity() {

    private var selectedDateLayout: LinearLayout? = null
    private var selectedTimeView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_tanggal_jambu_dua)
        supportActionBar?.hide()

        // --- LOGIC UNTUK PILIH TANGGAL ---
        val dateIds = listOf(R.id.date23, R.id.date24, R.id.date25, R.id.date26, R.id.date27)
        for (id in dateIds) {
            val dateLayout = findViewById<LinearLayout>(id)
            dateLayout.setOnClickListener { view ->
                val clickedLayout = view as LinearLayout

                if (clickedLayout != selectedDateLayout) {
                    // Reset tanggal yang dipilih sebelumnya
                    selectedDateLayout?.let { resetDateUI(it) }

                    // Ubah UI tanggal yang baru diklik jadi Hijau Tua
                    clickedLayout.setBackgroundResource(R.drawable.bg_date_selected)
                    // Ubah text color di dalamnya jadi putih
                    (clickedLayout.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                    (clickedLayout.getChildAt(1) as TextView).setTextColor(Color.WHITE)

                    selectedDateLayout = clickedLayout
                }
            }
        }

        // --- LOGIC UNTUK PILIH WAKTU ---
        val timeIds = listOf(
            R.id.time1, R.id.time2, R.id.time3, R.id.time4, R.id.time5,
            R.id.time6, R.id.time7, R.id.time8, R.id.time9, R.id.time10
        )
        for (id in timeIds) {
            val timeView = findViewById<TextView>(id)
            timeView.setOnClickListener { view ->
                val clickedTime = view as TextView

                if (clickedTime != selectedTimeView) {
                    // Reset waktu sebelumnya
                    selectedTimeView?.let { resetTimeUI(it) }

                    // Ubah UI waktu yang baru diklik jadi Hijau Muda
                    clickedTime.setBackgroundResource(R.drawable.bg_time_selected)
                    clickedTime.setTextColor(Color.WHITE)

                    selectedTimeView = clickedTime
                }
            }
        }

        // Navigasi Kembali
        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            // Nanti tambahin logic validasi: pastikan selectedDateLayout dan selectedTimeView gak null
            // val intent = Intent(this, KonfirmasiActivity::class.java)
            // startActivity(intent)
        }
    }

    // Fungsi untuk balikin UI Tanggal ke warna asal (Abu-abu & Teks Hitam/Abu)
    private fun resetDateUI(layout: LinearLayout) {
        layout.setBackgroundResource(R.drawable.bg_date_unselected)
        (layout.getChildAt(0) as TextView).setTextColor(Color.parseColor("#000000")) // Angka
        (layout.getChildAt(1) as TextView).setTextColor(Color.parseColor("#555555")) // Hari
    }

    // Fungsi untuk balikin UI Waktu ke warna asal (Abu-abu & Teks Hitam)
    private fun resetTimeUI(textView: TextView) {
        textView.setBackgroundResource(R.drawable.bg_time_unselected)
        textView.setTextColor(Color.parseColor("#000000"))
    }
}