package com.ereyes.chatrealtimedatabase.common

import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.Locale

/****
 * Project: ChatRealtimeDatabase
 * From: com.ereyes.chatrealtimedatabase.common
 * Created by Edgar Reyes Gonzalez on 5/6/2024 at 11:49 AM
 * All rights reserved 2024.
 ****/

fun getMonthName(month: Int): String {
    val cal = Calendar.getInstance()
    cal.set(Calendar.MONTH, month)
    val dateFormat = SimpleDateFormat("MMMM", Locale.getDefault())

    return dateFormat.format(cal.time)
}

fun getCalendar(): Calendar {
    return Calendar.getInstance()
}

fun getHour(): Int = getCalendar().get(Calendar.HOUR_OF_DAY)

fun getMin(): Int = getCalendar().get(Calendar.MINUTE)

fun getYear(): Int = getCalendar().get(Calendar.YEAR)

fun getMoth(): Int = getCalendar().get(Calendar.MONTH)

fun getDay(): Int = getCalendar().get(Calendar.DAY_OF_MONTH)

fun getHourMin(): String =  "${getHour()}:${getMin()}"

fun getDateFormat(): String{
    val calendar = getCalendar()
    return "${getDay()} de ${getMonthName(getMoth())} de ${getYear()}"
}