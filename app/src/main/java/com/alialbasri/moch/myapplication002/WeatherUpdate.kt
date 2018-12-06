package com.alialbasri.moch.myapplication002

import com.google.gson.annotations.SerializedName

class WeatherUpdate {

    @SerializedName("weather_state_name")
    var weatherStateName: String = ""

    @SerializedName("the_temp")
    var theTemp: Float = 0f

    var humidity: Float = 0f

}