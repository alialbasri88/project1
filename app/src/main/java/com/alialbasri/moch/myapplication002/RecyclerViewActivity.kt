package com.alialbasri.moch.myapplication002

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)



        val emp1 : empClass = empClass("Ali","Developer","IT",30)
        val emp2 : empClass = empClass("Mohamed","Eng","IT",60)
        val emp3 : empClass = empClass("Samir","Driver","Administrative Dept",50)




        val empArray = listOf(emp1,emp2,emp3)


        val adapter = AdapterClass(empArray)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
