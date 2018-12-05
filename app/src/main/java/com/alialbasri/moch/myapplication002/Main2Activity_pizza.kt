package com.alialbasri.moch.myapplication002

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2_pizza.*

class Main2Activity_pizza : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2_pizza)

        var sp = sharedPreferences()

        tipEB.setText(sp.getAnyPreference(this,"tip",sharedPreferences.types.Strings).toString())

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            order()
        }


        pepsiCB.setOnClickListener{
            order()
        }
        friesCB.setOnClickListener{
            order()
        }
        garlicCB.setOnClickListener{
            order()
        }

        tipEB.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                order()

                if (!sp.setAnyPreference(this@Main2Activity_pizza,"tip",tipEB.text.toString(),sharedPreferences.types.Strings)) {
                    Toast.makeText(this@Main2Activity_pizza,"tip value has NOT been saved",Toast.LENGTH_SHORT)
                }






            }

        })


        orderB.setOnClickListener{

            order()

        }
    }


    private fun order () {

        var price: Float = 0f

        when(radioGroup.checkedRadioButtonId){
            oliveRB.id -> price += 6.5f
            appleRB.id -> price += 20f
            chinesRB.id -> price += 5f
            sausageRB.id -> price += 8f
            else -> {
                Toast.makeText(this,getString(R.string.pizza_type_validation),Toast.LENGTH_SHORT).show()
                return
            }
        }

        if (friesCB.isChecked) price += 2f
        if (garlicCB.isChecked) price += 0.2f
        if (pepsiCB.isChecked) price += 0.5f

        if (tipEB.text.toString().isNotEmpty()){
            val tip :Float = tipEB.text.toString().toFloat()
            price += tip
        }


        resultTV.text = price.toString()


    }
}
