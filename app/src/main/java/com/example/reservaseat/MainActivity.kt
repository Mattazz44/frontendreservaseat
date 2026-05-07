package com.example.reservaseat

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        // ===== INIT VIEW =====
        bannerSlider = findViewById(R.id.bannerSlider)
        dotsLayout = findViewById(R.id.dotsLayout)
        recommendSlider = findViewById(R.id.recommendSlider)

        // ===== SET ADAPTER =====
        bannerSlider.adapter = BannerAdapter(bannerImages)
        recommendSlider.adapter = BannerAdapter(recommendImages)

        // ===== ANIMASI BANNER =====
        bannerSlider.setPageTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
            page.alpha = 0.5f + r * 0.5f
        }

        // ===== ANIMASI REKOMENDASI =====
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

    // ===== DOTS BANNER =====
    private fun setupDots() {
        val dots = List(dotsLayout.childCount) { i -> dotsLayout.getChildAt(i) }

        bannerSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dots.forEachIndexed { index, view ->
                    view.backgroundTintList =
                        if (index == position)
                            getColorStateList(R.color.dot_active)
                        else
                            getColorStateList(R.color.dot_inactive)
                }
            }
        })
    }

    // ===== START AUTO =====
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