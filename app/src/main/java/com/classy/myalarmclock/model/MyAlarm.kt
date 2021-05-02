package com.classy.myalarmclock.model

class MyAlarm(hours : Int, minutes: Int) {
    var hours : Int
    var minutes : Int

    init {
        this.hours = hours
        this.minutes = minutes
    }

    override fun toString(): String {
        return "MyAlarm(hours=$hours, minutes=$minutes)"
    }


}