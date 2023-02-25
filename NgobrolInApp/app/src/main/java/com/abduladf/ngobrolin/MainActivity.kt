package com.abduladf.ngobrolin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abduladf.ngobrolin.data.remote.DinotisApiService
import com.abduladf.ngobrolin.model.ApiResponseListCreators
import com.abduladf.ngobrolin.model.ApiResponseMeetings
import com.abduladf.ngobrolin.model.ApiResponseUsers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.hackathon.dinotis.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dinotisService = retrofit.create(DinotisApiService::class.java)

        dinotisService.getUser().enqueue(object : Callback<ApiResponseUsers> {
            override fun onResponse(call: Call<ApiResponseUsers>, response: Response<ApiResponseUsers>) {
                val user = response.body()?.user
                if (user != null) {
                    println(user.id)
                    println(user.name)
                    println(user.phone)
                    println(user.username)
                    println(user.profilePhoto)
                }
            }

            override fun onFailure(call: Call<ApiResponseUsers>, t: Throwable) {
                println("error")
            }
        })

        dinotisService.getCreators().enqueue(object : Callback<ApiResponseListCreators> {
            override fun onResponse(call: Call<ApiResponseListCreators>, response: Response<ApiResponseListCreators>) {
                val creators = response.body()?.creators
            }

            override fun onFailure(call: Call<ApiResponseListCreators>, t: Throwable) {
                println("error")
            }
        })

        dinotisService.getMeetings().enqueue(object : Callback<ApiResponseMeetings> {
            override fun onResponse(call: Call<ApiResponseMeetings>, response: Response<ApiResponseMeetings>) {
                val meetings = response.body()?.meetings
                println(meetings)
            }

            override fun onFailure(call: Call<ApiResponseMeetings>, t: Throwable) {
                println("error")
            }
        })

        setContentView(R.layout.activity_main)
    }
}