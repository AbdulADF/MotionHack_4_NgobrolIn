package com.abduladf.ngobrolin.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abduladf.ngobrolin.data.remote.DinotisApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {
    private val creators = MutableLiveData<List<Creator>>()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.hackathon.dinotis.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dinotisService = retrofit.create(DinotisApiService::class.java)

    fun getCreators(): LiveData<List<Creator>> {
        dinotisService.getCreators().enqueue(object : Callback<ApiResponseListCreators> {
            override fun onResponse(
                call: Call<ApiResponseListCreators>,
                response: Response<ApiResponseListCreators>
            ) {
                if (response.isSuccessful) {
                    creators.value = response.body()?.creators
                }
            }

            override fun onFailure(call: Call<ApiResponseListCreators>, t: Throwable) {
                println("error")
            }
        })
        return creators
    }
}