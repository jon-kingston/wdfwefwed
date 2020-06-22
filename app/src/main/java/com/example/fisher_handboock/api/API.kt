package com.example.secondfbtect.api

import com.example.secondfbtect.Pictures
import com.example.secondfbtect.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("users/{id}")
    fun getUserById(@Path("id") id: String) : Call<User>

    @GET("photos/{id}")
    fun getPictureById(@Path("id") id: String) : Call<Pictures>

    @GET("photos")
    fun getPicturs() : Call<ArrayList<Pictures>>
}