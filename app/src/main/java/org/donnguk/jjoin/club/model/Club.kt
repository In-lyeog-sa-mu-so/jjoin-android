package org.donnguk.jjoin.club.model

import java.time.LocalDate

data class Club(
    val id: Int,
    val name: String,
    val tags: String,
    val description: String,
    val leader: String,
    val memberNum: String,
    val openDate: LocalDate,
    val department: String,
    val isJoinEnable: Boolean,
) {
    fun getDate(): String {
        return "${openDate.year}년 ${openDate.monthValue}월"
    }
}