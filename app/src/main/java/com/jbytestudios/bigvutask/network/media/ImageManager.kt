package com.jbytestudios.bigvutask.network.media

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jbytestudios.bigvutask.R

object ImageManager {

    fun loadImage(imageUrl: String?, imageView: ImageView) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(imageView.context).load(imageUrl).placeholder(R.drawable.ic_baseline_person_24).error(R.drawable.ic_baseline_person_24).into(imageView)
        }
    }

    fun loadRoundedImage(imageUrl:String?, imageView: ImageView) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(imageView.context).load(imageUrl).circleCrop().placeholder(R.drawable.ic_baseline_person_24).error(R.drawable.ic_baseline_person_24).into(imageView)
        }
    }

}