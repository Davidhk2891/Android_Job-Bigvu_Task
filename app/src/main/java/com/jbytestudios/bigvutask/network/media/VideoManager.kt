package com.jbytestudios.bigvutask.network.media

import android.content.Context
import android.net.Uri
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.VideoView

object VideoManager {

    fun loadVideo(context: Context, videoUrl: String, videoView: VideoView){

        // declare a null variable for MediaController
        var mediaControls: MediaController? = null

        if (mediaControls == null) {
            // creating an object of media controller class
            mediaControls = MediaController(context)

            // set the anchor view for the video view
            //mediaControls.setAnchorView(videoView)
        }

        // set the media controller for video view
        videoView.setMediaController(mediaControls)

        // set the absolute path of the video file which is going to be played
        videoView.setVideoURI(Uri.parse(videoUrl))
        videoView.requestFocus()
        videoView.start()

        videoView.setOnCompletionListener {
            TODO("No implementation yet")
        }

        videoView.setOnErrorListener { _, _, _ ->
            TODO("No implementation yet")
        }
    }

}