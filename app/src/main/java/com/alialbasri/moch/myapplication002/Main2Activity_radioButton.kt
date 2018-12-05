package com.alialbasri.moch.myapplication002

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2_radio_button.*

class Main2Activity_radioButton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_radio_button)


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
         calculate()
        }

        no1ET.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                calculate()

            }

        })

        no2ET.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                calculate()

            }

        })


    }

    fun calculate() {


        if (no1ET.text.toString() == "" && no2ET.text.toString() == "") {
            Toast.makeText(this, "numbers must not be empty", Toast.LENGTH_SHORT).show()
            return
        }

        val number1 = no1ET.text.toString().toFloat()
        val number2 = no2ET.text.toString().toFloat()
        var result: Float = 0f

        when (radioGroup.checkedRadioButtonId) {
            plusRB.id -> {
                result = number1 + number2
            }
            minusRB.id -> {
                result = number1 - number2
            }
            multiRB.id -> {
                result = number1 * number2
            }
            divideRB.id -> {
                if (number2 == 0f) {
                    Toast.makeText(this, "Cannot divide by Zero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = number1 / number2
            }

        }

        ResultTV.text = result.toString()


    }
}
