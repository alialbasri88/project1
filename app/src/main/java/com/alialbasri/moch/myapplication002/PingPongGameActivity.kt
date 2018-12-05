package com.alialbasri.moch.myapplication002

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ping_pong_game.*
import android.content.Intent



class PingPongGameActivity : AppCompatActivity() {

    private var APoints: Int = 0
    private var BPoints: Int = 0



    public override fun onStop() {
        super.onStop()

        var sp = sharedPreferences()

        sp.setAnyPreference(this,"aPoints", APoints,sharedPreferences.types.Integers)
        sp.setAnyPreference(this,"bPoints",BPoints,sharedPreferences.types.Integers)



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ping_pong_game)

        this.title = "Let`s Play Ping Pong"

        pointToAB.setOnClickListener {
            APoints +=1
            checkA()
        }

        pointToBB.setOnClickListener {
            BPoints +=1
            checkB()
        }

        resetB.setOnClickListener {

            en_dis(true)

        }

        var sp = sharedPreferences()

        APoints = sp.getAnyPreference(this,"aPoints",sharedPreferences.types.Integers).toString().toInt()
        BPoints = sp.getAnyPreference(this,"bPoints",sharedPreferences.types.Integers).toString().toInt()

        checkA()
        checkB()

    }

    @SuppressLint("SetTextI18n")


    private fun en_dis(v:Boolean){

        if (v){
            APoints = 0
            BPoints = 0

            teamAScooreTV.text = "0"
            teamBScooreTV.text = "0"

            resultTV.text = ""


        }

        pointToAB.isClickable=v
        pointToAB.isEnabled = v

        pointToBB.isClickable=v
        pointToBB.isEnabled = v

    }


    fun checkA(){



        when {
            APoints < 10 -> {
                teamAScooreTV.text = APoints.toString()  + getString(R.string.down)
            }
            APoints in 11..19 -> {
                teamAScooreTV.text = (APoints % 10).toString()  + getString(R.string.up)
            }
            else ->{
                teamAScooreTV.text = APoints.toString()
            }

        }


        if (APoints == 7 && BPoints ==0){

            resultTV.text = "A Team is the winner with Score :$APoints to $BPoints"
            en_dis(false)
            return
        }

        if(APoints == 21){

            resultTV.text = "A Team is the winner with Score :$APoints to $BPoints"
            en_dis(false)
            return
        }


    }


    fun checkB(){
        when {
            BPoints < 10 -> {
                teamBScooreTV.text = BPoints.toString()  + getString(R.string.down)
            }
            BPoints in 11..19 -> {
                teamBScooreTV.text = (BPoints % 10).toString()  + getString(R.string.up)
            }
            else ->{
                teamBScooreTV.text = BPoints.toString()
            }

        }


        if (BPoints == 7 && APoints ==0){

            resultTV.text = "B Team is the winner with Score :$BPoints to $APoints"
            en_dis(false)
            return
        }

        if(BPoints == 21){

            resultTV.text = "B Team is the winner with Score :$BPoints to $APoints"
            en_dis(false)
            return
        }
    }
}
