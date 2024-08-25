package com.task.timewraph

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Sample video list
        val videoList = listOf(
            Video("Video 1", R.raw.video1),
            Video("Video 2", R.raw.video2),
            Video("Video 3", R.raw.video3)
        )

        recyclerView = findViewById(R.id.recyclerView)

        videoAdapter = VideoAdapter(videoList, this)
        recyclerView.adapter = videoAdapter
    }
}