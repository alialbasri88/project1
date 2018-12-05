package com.alialbasri.moch.myapplication002

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_emp.view.*

class AdapterClass : RecyclerView.Adapter<AdapterClass.EmpViewHolder> {


    // carsList of items
    val carsList: List<empClass>

    // constructor to pass the items from Activity
    constructor(empList: List<empClass>) : super() {
        this.carsList = empList
    }

    // inflate the layout you created in res/layout
    // and return a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EmpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_emp, parent, false)
        return EmpViewHolder(view)
    }


    // get the count of carsList items to create rows accordingly
    override fun getItemCount(): Int {
        return carsList.size

    }
    // bind data and layout using the viewHolder and position to get data from carsList
    override fun onBindViewHolder(holder: EmpViewHolder, i: Int) {

        holder.empNameTextView.text = carsList[i].empName
        holder.empJobTitleTextView.text = carsList[i].jobTitle
        holder.empOUTextView.text = carsList[i].ou
        holder.empAgeTextView.text = carsList[i].age.toString()
    }






    // this is the ViewHolder's class
    class EmpViewHolder : RecyclerView.ViewHolder {

        val empNameTextView: TextView
        val empJobTitleTextView: TextView
        val empOUTextView: TextView
        val empAgeTextView: TextView


        constructor(view: View) : super(view) {
            empNameTextView = view.empNameTV
            empJobTitleTextView = view.empJobTitleTV
            empOUTextView = view.empOuTV
            empAgeTextView = view.empAgeTV
        }
    }

}