package com.alialbasri.moch.myapplication002

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface WeatherInterface {

    @GET("location/{id}/")
    fun getCityInfo(@Path("id") cityId:Int): Call<City>



}