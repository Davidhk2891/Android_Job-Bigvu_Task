package com.jbytestudios.bigvutask.network

import com.jbytestudios.bigvutask.model.Workshop
import com.jbytestudios.bigvutask.utils.BIGVULog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Class for initializing Retrofit 2
object DataSource {

    const val TAG = "DataSource"

    fun fetchData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NetworkConstants.BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getWorkshops()

        BIGVULog.i(TAG, "retrofitService")
        retrofitData.enqueue(object: Callback<List<Workshop>?>{
            override fun onResponse(call: Call<List<Workshop>?>, response: Response<List<Workshop>?>) {
                val responseBody = response.body()!!

                //Get the data from the API

            }

            override fun onFailure(call: Call<List<Workshop>?>, t: Throwable) {
                //Handle failure
                BIGVULog.i(TAG, "retrofitService", "Error: ${t.message}")
            }
        })
    }

}