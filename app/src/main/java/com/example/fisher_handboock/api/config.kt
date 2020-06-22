package com.example.secondfbtect.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getAPI() = getRetrofit().create(API::class.java)

fun getRetrofit() : Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}