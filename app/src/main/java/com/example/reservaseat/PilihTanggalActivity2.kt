package com.example.reservaseat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PilihTanggalActivity2 : AppCompatActivity() {

    private var selectedDateLayout: LinearLayout? = null
    private var selectedTimeView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_tanggal_jambu_dua)
        supportActionBar?.hide()

        val dateIds = listOf(R.id.date23, R.id.date24, R.id.date25, R.id.date26, R.id.date27)
        for (id in dateIds) {
            val dateLayout = findViewById<LinearLayout>(id)
            dateLayout.setOnClickListener { view ->
                val clickedLayout = view as LinearLayout
                if (clickedLayout != selectedDateLayout) {
                    selectedDateLayout?.let { resetDateUI(it) }
                    clickedLayout.setBackgroundResource(R.drawable.bg_date_selected)
                    (clickedLayout.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                    (clickedLayout.getChildAt(1) as TextView).setTextColor(Color.WHITE)
                    selectedDateLayout = clickedLayout
                }
            }
        }

        val timeIds = listOf(
            R.id.time1, R.id.time2, R.id.time3, R.id.time4, R.id.time5,
            R.id.time6, R.id.time7, R.id.time8, R.id.time9, R.id.time10
        )
        for (id in timeIds) {
            val timeView = findViewById<TextView>(id)
            timeView.setOnClickListener { view ->
                val clickedTime = view as TextView
                if (clickedTime != selectedTimeView) {
                    selectedTimeView?.let { resetTimeUI(it) }
                    clickedTime.setBackgroundResource(R.drawable.bg_time_selected)
                    clickedTime.setTextColor(Color.WHITE)
                    selectedTimeView = clickedTime
                }
            }
        }

        findViewById<ImageView>(R.id.btnBackHeader).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnKembali).setOnClickListener { finish() }

        // Tombol Lanjutkan — navigasi ke PilihKursiActivity2
        findViewById<Button>(R.id.btnLanjutkan).setOnClickListener {
            if (selectedDateLayout == null || selectedTimeView == null) {
                Toast.makeText(this, "Silakan pilih tanggal dan waktu terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, PilihKursiActivity2::class.java))
            }
        }
    }

    private fun resetDateUI(layout: LinearLayout) {
        layout.setBackgroundResource(R.drawable.bg_date_unselected)
        (layout.getChildAt(0) as TextView).setTextColor(Color.parseColor("#000000"))
        (layout.getChildAt(1) as TextView).setTextColor(Color.parseColor("#555555"))
    }

    private fun resetTimeUI(textView: TextView) {
        textView.setBackgroundResource(R.drawable.bg_time_unselected)
        textView.setTextColor(Color.parseColor("#000000"))
    }
}
