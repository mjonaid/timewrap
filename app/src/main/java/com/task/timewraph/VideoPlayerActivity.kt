package com.task.timewraph


import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        videoView = findViewById(R.id.videoView)

        // Get the video resource ID from the Intent
        val videoResId = intent.getIntExtra("VIDEO_RES_ID", -1)

        if (videoResId != -1) {
            val videoUri = Uri.parse("android.resource://${packageName}/$videoResId")
            videoView.setVideoURI(videoUri)
            videoView.start()
        }
    }
}
