package com.classy.myalarmclock.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.classy.myalarmclock.R
import com.classy.myalarmclock.model.MyAlarm

class AlarmAdapter(private val alarms: ArrayList<MyAlarm>) : RecyclerView.Adapter<AlarmAdapter.AlarmHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.alarms_item_row, parent, false)
        return AlarmHolder(v)
    }

    override fun onBindViewHolder(holder: AlarmHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.row_TXT_alarm).text = alarms[position].toString()
    }

    override fun getItemCount(): Int {
        return alarms.size
    }

    fun addAlarm(alarm: MyAlarm) {
        alarms.add(alarm)
    }

    class AlarmHolder(v: View) : RecyclerView.ViewHolder(v) {
        private lateinit var row_TXT_alarm : TextView
        private lateinit var row_BTN_remove : Button


    }

}