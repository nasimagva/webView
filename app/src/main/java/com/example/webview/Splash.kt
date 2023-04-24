package com.example.webview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import java.lang.Exception

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            val video: Uri =Uri.parse("android.resource://" +packageName + "/" + R.raw.splash_video)
            val videoView = findViewById<VideoView>(R.id.videoView)
            videoView.setVideoURI(video)
            videoView.setOnCompletionListener { navigateToMain() }
            videoView.start()
        }catch (e: Exception){
            withDelay(2000){
                navigateToMain()
            }
        }
    }
    private fun navigateToMain(){
        if (isFinishing)return
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}