package com.example.reservaseat

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    // ===== BANNER ATAS =====
    private lateinit var bannerSlider: ViewPager2
    private lateinit var dotsLayout: LinearLayout
    private val bannerHandler = Handler(Looper.getMainLooper())

    private val bannerImages = listOf(
        R.drawable.food_one,
        R.drawable.food_two,
        R.drawable.food_three
    )

    private val bannerAutoScroll = object : Runnable {
        override fun run() {
            val next = (bannerSlider.currentItem + 1) % bannerImages.size
            bannerSlider.setCurrentItem(next, true)
            bannerHandler.postDelayed(this, 3000)
        }
    }

    // ===== REKOMENDASI =====
    private lateinit var recommendSlider: ViewPager2
    private val recommendHandler = Handler(Looper.getMainLooper())

    private val recommendImages = listOf(
        R.drawable.rekomendasi_satu,
        R.drawable.rekomendasi_2,
        R.drawable.rekomendasi_3
    )

    private val recommendAutoScroll = object : Runnable {
        override fun run() {
            val next = (recommendSlider.currentItem + 1) % recommendImages.size
            recommendSlider.setCurrentItem(next, true)
            recommendHandler.postDelayed(this, 4000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        // ===== INIT VIEW =====
        bannerSlider = findViewById(R.id.bannerSlider)
        dotsLayout = findViewById(R.id.dotsLayout)
        recommendSlider = findViewById(R.id.recommendSlider)

        val btnReservasi = findViewById<Button>(R.id.btnReservasi)
        val cardBotas = findViewById<CardView>(R.id.cardBotas)
        val cardJambuDua = findViewById<CardView>(R.id.cardJambuDua)
        val btnWallet = findViewById<FrameLayout>(R.id.btnWallet)
        val ivProfile = findViewById<ImageView>(R.id.ivProfile)
        val btnReserveList = findViewById<ImageView>(R.id.btnReserveList)
        val btnFavorite = findViewById<ImageView>(R.id.btnFavorite)
        val btnLocationPicker = findViewById<LinearLayout>(R.id.btnLocationPicker)
        val btnCompass = findViewById<ImageView>(R.id.btnCompass)
        
        // Navigation Bar
        val navHome = findViewById<ImageView>(R.id.navHome)
        val navReceipt = findViewById<ImageView>(R.id.navReceipt)
        val navProfile = findViewById<ImageView>(R.id.navProfile)

        // ===== SET CLICK LISTENERS =====
        
        btnReservasi.setOnClickListener {
            startActivity(Intent(this, PilihCabangActivity::class.java))
        }

        cardBotas.setOnClickListener {
            // Langsung ke alur Botas (Pilih Tanggal)
            startActivity(Intent(this, PilihTanggalActivity::class.java))
        }

        cardJambuDua.setOnClickListener {
            // Langsung ke alur Jambu Dua (Pilih Tanggal 2)
            startActivity(Intent(this, PilihTanggalActivity2::class.java))
        }

        btnWallet.setOnClickListener {
            Toast.makeText(this, "Fitur Wallet segera hadir", Toast.LENGTH_SHORT).show()
        }

        ivProfile.setOnClickListener {
            Toast.makeText(this, "Halaman Profil segera hadir", Toast.LENGTH_SHORT).show()
        }

        btnReserveList.setOnClickListener {
            Toast.makeText(this, "Daftar Reservasi Anda", Toast.LENGTH_SHORT).show()
        }

        btnFavorite.setOnClickListener {
            Toast.makeText(this, "Daftar Favorit Anda", Toast.LENGTH_SHORT).show()
        }

        btnLocationPicker.setOnClickListener {
            Toast.makeText(this, "Pilih Lokasi", Toast.LENGTH_SHORT).show()
        }

        btnCompass.setOnClickListener {
            Toast.makeText(this, "Mencari cabang terdekat...", Toast.LENGTH_SHORT).show()
        }

        // Navigasi Bawah
        navHome.setOnClickListener {
            Toast.makeText(this, "Anda sudah berada di Home", Toast.LENGTH_SHORT).show()
        }

        navReceipt.setOnClickListener {
            Toast.makeText(this, "Riwayat Transaksi segera hadir", Toast.LENGTH_SHORT).show()
        }

        navProfile.setOnClickListener {
            Toast.makeText(this, "Profil User segera hadir", Toast.LENGTH_SHORT).show()
        }

        // ===== SET ADAPTER & SLIDER =====
        bannerSlider.adapter = BannerAdapter(bannerImages)
        recommendSlider.adapter = BannerAdapter(recommendImages)

        bannerSlider.setPageTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
            page.alpha = 0.5f + r * 0.5f
        }

        recommendSlider.setPageTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.9f + r * 0.1f
            page.alpha = 0.6f + r * 0.4f
        }

        bannerSlider.offscreenPageLimit = 3
        recommendSlider.offscreenPageLimit = 3

        setupDots()
        startAutoSlide()
    }

    private fun setupDots() {
        // Karena child ditambahkan manual di layout, kita ambil manual atau biarkan dinamis
        // Untuk saat ini kita biarkan fungsi setup ini agar tidak error dengan code sebelumnya
    }

    private fun startAutoSlide() {
        bannerHandler.postDelayed(bannerAutoScroll, 3500)
        recommendHandler.postDelayed(recommendAutoScroll, 4000)
    }

    override fun onPause() {
        super.onPause()
        bannerHandler.removeCallbacks(bannerAutoScroll)
        recommendHandler.removeCallbacks(recommendAutoScroll)
    }

    override fun onResume() {
        super.onResume()
        bannerHandler.postDelayed(bannerAutoScroll, 3500)
        recommendHandler.postDelayed(recommendAutoScroll, 4000)
    }
}
