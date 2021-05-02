package com.classy.myalarmclock

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.classy.myalarmclock.adapters.AlarmAdapter
import com.classy.myalarmclock.model.MyAlarm
import java.util.*

class MainActivity : AppCompatActivity() {

//    private lateinit var main_BTN_addAlarm : Button
      private lateinit var alarmAdapter : AlarmAdapter
      private lateinit var main_LST_alarms : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        initRecycler()


    }

    private fun initRecycler() {
        val alarms = ArrayList<MyAlarm>()
        alarmAdapter = AlarmAdapter(alarms)
        main_LST_alarms.adapter = alarmAdapter
        main_LST_alarms.layoutManager = LinearLayoutManager(this)
        alarmAdapter.notifyDataSetChanged()
    }

    private fun findViews() {
        //main_BTN_addAlarm = findViewById(R.id.main_BTN_addAlarm)
        main_LST_alarms = findViewById(R.id.main_LST_alarms)
    }

    fun addAlarm(view: View) {
        val calendar = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hours, minutes ->
            calendar.set(Calendar.HOUR_OF_DAY, hours)
            calendar.set(Calendar.MINUTE, minutes)
            var alarm = MyAlarm(hours, minutes)
            alarmAdapter.addAlarm(alarm)
            alarmAdapter.notifyDataSetChanged()
        }
        TimePickerDialog(view.context, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
    }

}