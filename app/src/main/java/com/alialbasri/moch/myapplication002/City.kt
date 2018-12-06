package com.alialbasri.moch.myapplication002

import com.google.gson.annotations.SerializedName

class City {

    var title: String = ""
    var timezone : String = ""
    var time : String = ""

    @SerializedName("consolidated_weather")
    var weather : List<WeatherUpdate> = listOf()


}