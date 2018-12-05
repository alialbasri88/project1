package com.alialbasri.moch.myapplication002

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clearBT.setOnClickListener() {
            number1ET.text.clear()
            number2ET.text.clear()
            resultTV.text = ""
        }

        plusBT.setOnClickListener {
            calculate(it)
        }

        minusBT.setOnClickListener {
            calculate(it)
        }

        multiBT.setOnClickListener {
            calculate(it)
        }

        dividBT.setOnClickListener {
            calculate(it)
        }


    }


    fun calculate(view: View) {

        if (number1ET.text.toString() == "" && number1ET.text.toString() == "") {
            Toast.makeText(this, "numbers must not be empty", Toast.LENGTH_SHORT).show()
            return
        }

        val number1 = number1ET.text.toString().toFloat()
        val number2 = number2ET.text.toString().toFloat()
        var result: Float = 0f

        when (view.id) {
            plusBT.id -> {
                result = number1 + number2
            }
            minusBT.id -> {
                result = number1 - number2
            }
            multiBT.id -> {
                result = number1 * number2
            }
            dividBT.id -> {
                if (number2 == 0f) {
                    Toast.makeText(this, "Cannot divide by Zero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = number1 / number2
            }

        }

        resultTV.text = result.toString()


    }

}
