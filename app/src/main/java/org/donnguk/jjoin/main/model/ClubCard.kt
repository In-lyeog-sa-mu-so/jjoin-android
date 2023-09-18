package org.donnguk.jjoin.main.model

data class ClubCard(
    val id: Int,
    val title: String,
    val description: String,
    val number: Int,
    val department: String,
    val tag: String,
) {
    fun numberToString(): String {
        return "$number 명"
    }
}