package com.task.timewraph

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri

fun getVideoThumbnail(context: Context, videoResId: Int): Bitmap? {
    val retriever = MediaMetadataRetriever()
    val fileUri = Uri.parse("android.resource://${context.packageName}/$videoResId")
    return try {
        retriever.setDataSource(context, fileUri)
        retriever.getFrameAtTime(1_000_000) // Get frame at 1 second
    } catch (e: Exception) {
        e.printStackTrace()
        null
    } finally {
        retriever.release()
    }
}
