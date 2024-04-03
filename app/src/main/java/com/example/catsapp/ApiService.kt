package com.example.catsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("cats")
    fun getCat(@Query("name") name: String, @Header("X-Api-Key") apiKey: String): Call<List<Cat>>
}


