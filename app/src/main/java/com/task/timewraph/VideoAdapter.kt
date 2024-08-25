package com.task.timewraph

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val videoList: List<Video>, private val context: Context) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoTitle: TextView = itemView.findViewById(R.id.videoTitle)
        private val videoThumbnail: ImageView = itemView.findViewById(R.id.videoThumbnail)

        fun bind(video: Video) {
            videoTitle.text = video.title

            // Set video thumbnail
            val thumbnail: Bitmap? = getVideoThumbnail(context, video.videoResId)
            if (thumbnail != null) {
                videoThumbnail.setImageBitmap(thumbnail)
            } else {
                videoThumbnail.setImageResource(R.drawable.ic_launcher_background) // Fallback image
            }

            // Open the video in VideoPlayerActivity
            itemView.setOnClickListener {
                val intent = Intent(context, VideoPlayerActivity::class.java).apply {
                    putExtra("VIDEO_RES_ID", video.videoResId)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    override fun getItemCount(): Int = videoList.size
}
