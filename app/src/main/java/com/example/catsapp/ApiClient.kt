package com.example.catsapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.api-ninjas.com/v1/"
    private const val API_KEY = "UH5BsVA+xU/XqYIniz8jQw==vxyM9XlQev3qQHwr"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    fun fetchCatsByName(name: String) {
        val call = apiService.getCat(name, API_KEY)
        call.enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                if (response.isSuccessful) {
                    val cats = response.body()
                    println(cats)
                } else {
                    println("Error: ${response.code()} ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}

fun main() {
    val name = "abyssinian"
    ApiClient.fetchCatsByName(name)
}
