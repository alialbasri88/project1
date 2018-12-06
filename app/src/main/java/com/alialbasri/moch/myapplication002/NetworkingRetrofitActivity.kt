package com.alialbasri.moch.myapplication002

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_networking_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkingRetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_networking_retrofit)

        var retrofit = Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherInterface = retrofit.create(WeatherInterface :: class.java)

        weatherInterface.getCityInfo(1979455)
            .enqueue(object: Callback<City> {
                override fun onFailure(call: Call<City>, t: Throwable) {
                    Toast.makeText(this@NetworkingRetrofitActivity, t.message,Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<City>, response: Response<City>) {

                    response.body()?.let {

                        cityTV.text = it.title
                        timeZoneTV.text = it.timezone
                        timeTV.text = it.time
                        weatherTV.text = it.weather[0].weatherStateName
                        tempTV.text = it.weather[0].theTemp.toString()
                    }



                }

            })



    }
}
