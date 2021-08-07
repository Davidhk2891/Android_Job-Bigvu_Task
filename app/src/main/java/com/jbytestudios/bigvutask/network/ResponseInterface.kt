package com.jbytestudios.bigvutask.network

import com.jbytestudios.bigvutask.model.Workshop

interface ResponseInterface {
    fun onResponse(workshopList: MutableList<Workshop>)
    fun onFailure(errorMessage: String)
}