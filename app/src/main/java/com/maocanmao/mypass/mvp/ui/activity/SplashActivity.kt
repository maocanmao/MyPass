package com.maocanmao.mypass.mvp.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewCompat
import android.view.animation.DecelerateInterpolator
import com.maocanmao.mypass.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private val animationStarted = false
    private val handler: Handler = Handler()
    private lateinit var  runnable :Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        runnable = Runnable {
            startActivity(Intent(this,MainActivity().javaClass))
            finish()
        }

        handler.postDelayed(runnable, 2000)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {

        if (!hasFocus || animationStarted) {
            return
        }
        animate()
        super.onWindowFocusChanged(hasFocus)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    private fun animate() {
        ViewCompat.animate(imgLogo)
                .translationY(-250f)
                .alpha(50f)
                .setStartDelay(300)
                .setDuration(1000).setInterpolator(DecelerateInterpolator(1.2f))
                .start()
    }
}
