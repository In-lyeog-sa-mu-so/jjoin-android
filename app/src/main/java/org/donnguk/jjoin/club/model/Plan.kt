package org.donnguk.jjoin.club.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Plan(
    val id: Int,
    val title: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val isAgree: Boolean? = null,
) {
    fun getStartDateStr(): String {
        return startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))
    }

    fun getEndDateStr(): String {
        return endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))
    }
}
