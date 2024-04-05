package com.example.catsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key: UH5BsVA+xU/XqYIniz8jQw==vxyM9XlQev3qQHwr")
    @GET("cats")
    fun getCat(@Query("name") name: String): Call<List<Cat>>
}


