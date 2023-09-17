package org.donnguk.jjoin.main.model

data class ClubCard(
    val id: Int,
    val title: String,
    val description: String,
    val leaderName: String,
    val number: Int,
    val department: String,
    val recentNotice: String,
)