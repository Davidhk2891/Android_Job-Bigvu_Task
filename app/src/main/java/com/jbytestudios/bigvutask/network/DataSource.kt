package com.jbytestudios.bigvutask.network

import com.jbytestudios.bigvutask.model.Workshop
import com.jbytestudios.bigvutask.utils.BIGVULog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataSource {

    const val TAG = "DataSource"

    fun fetchData(responseInterface: ResponseInterface) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NetworkConstants.BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getWorkshops()

        BIGVULog.i(TAG, "fetchData called")
        retrofitData.enqueue(object: Callback<MutableList<Workshop>?>{
            override fun onResponse(
                call: Call<MutableList<Workshop>?>,
                response: Response<MutableList<Workshop>?>
            ) {
                val responseBody = response.body()!!
                responseInterface.onResponse(responseBody)
                BIGVULog.i(TAG, "fetchData", responseBody.toString())
            }

            override fun onFailure(call: Call<MutableList<Workshop>?>, t: Throwable) {
                //Handle failure
                BIGVULog.i(TAG, "retrofitService", "Error: ${t.message}")
                t.message?.let { responseInterface.onFailure(it) }
            }
        })
    }



}