package com.jbytestudios.bigvutask.network

import com.jbytestudios.bigvutask.model.Workshop
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(NetworkConstants.END_POINT_WORKSHOPS)
    fun getWorkshops(): Call<List<Workshop>>
}