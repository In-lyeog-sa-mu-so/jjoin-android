package org.donnguk.jjoin.main.model

import org.donnguk.jjoin.main.util.CalenderUtil
import java.time.LocalDate

data class Calender(
    val date: LocalDate,
    val isExpand: Boolean,
) {
    fun getCalenderString(): String {
        return if (isExpand)
            "${date.year}년 ${date.monthValue}월"
        else
            CalenderUtil.getCurrentWeekOfMonth(date)
    }
}