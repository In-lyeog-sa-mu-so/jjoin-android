package org.donnguk.jjoin.club.model

import java.time.LocalDate

data class Notice(
    val id: Int,
    val title: String,
    val content: String,
    val updateDate: LocalDate,
) {
    fun getUpdateDateStr(): String {
        return updateDate.toString()
    }
}