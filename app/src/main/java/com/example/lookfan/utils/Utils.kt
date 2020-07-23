package com.example.lookfan.utils

import android.content.Context
import com.example.lookfan.R
import java.util.*

class Utils() {

    companion object {
        private var context: Context? = null

        val utils by lazy { Utils() }

        fun init(context: Context) {
            this.context = context.applicationContext
        }
    }



    fun getString(id:Int) : String? {
        return context?.resources?.getString(id)
    }

    fun getStringArray(id:Int): Array<String> {
        return context?.resources?.getStringArray(id)!!
    }

    fun getWeekOfDate(dt: Date?): Int {
        val weekDays = intArrayOf(6, 0, 1, 2, 3, 4, 5)
        val cal = Calendar.getInstance()
        cal.time = dt
        var w = cal[Calendar.DAY_OF_WEEK] - 1
        if (w < 0) w = 0
        return weekDays[w]
    }

    fun getVideoUrl(str:String) :String {
        return context!!.getString(R.string.url) + str
    }

}