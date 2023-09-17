package org.donnguk.jjoin.main.model

data class Notification(
    val id: Int,
    val clubName: String,
    val description: String,
    val isRead: Boolean,
)