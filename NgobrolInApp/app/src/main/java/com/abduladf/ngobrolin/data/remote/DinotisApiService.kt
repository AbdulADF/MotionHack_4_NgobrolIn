package com.abduladf.ngobrolin.data.remote

import com.abduladf.ngobrolin.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DinotisApiService {
    @GET("/v1/creators")
    fun getCreators(
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null,
        @Query("q") query: String? = null
    ): Call<ApiResponseListCreators>

    @GET("/v1/creators/{id}")
    fun getCreator(
        @Path("id") id: String
    ): Call<ApiResponseCreator>

    @GET("/v1/professions")
    fun getProfessions(
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null,
        @Query("q") query: String? = null
    ): Call<ApiResponseProfessions>

    @GET("/v1/meetings")
    fun getMeetings(
        @Query("page") page: Int? = null,
        @Query("size") size: Int? = null,
        @Query("q") query: String? = null
    ): Call<ApiResponseMeetings>

    @GET("/v1/users")
    fun getUser(): Call<ApiResponseUsers>
}