package com.example.demo.retrofit

import com.example.demo.model.UserDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("users")
    fun getServices(): Call<ArrayList<UserDataClass>>

    @GET("users/{users}")
    fun getDetailServices(@Path("users") uid: String?): Call<UserDataClass>
}