package org.donnguk.jjoin.main.model

import java.time.LocalDate

data class CalenderDay(
    val date: LocalDate,
    val isSelect: Boolean,
    val existInMonth: Boolean,
    val clubs: List<String>
) {
    fun getDayString(): String {
        return date.dayOfMonth.toString()
    }
}