package com.jbytestudios.bigvutask.model

import com.google.gson.annotations.SerializedName

data class Workshop(

    val name: String,
    val description: String,
    val text: String,

    @SerializedName("image")
    val imageUrl: String,

    val video: String
)
