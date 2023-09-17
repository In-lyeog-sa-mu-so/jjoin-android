package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.BaseViewModel
import org.donnguk.jjoin.main.model.Notification

class NotificationViewModel: BaseViewModel() {
    private val _notificationList = MutableLiveData<List<Notification>>()
    val notificationList: LiveData<List<Notification>> = _notificationList

    init {
        _notificationList.value = listOf(
            Notification(
                id = 1,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 2,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 3,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 4,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 5,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 6,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 7,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 8,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            ),
            Notification(
                id = 9,
                clubName = "동국대학교",
                description = "동국대학교에서 새로운 동아리가 개설되었습니다.",
                isRead = false
            )
        )
    }

    fun readNotification(id: Int) {
        // 알림 읽음 처리
        _notificationList.value = _notificationList.value?.map {
            if (it.id == id) {
                it.copy(isRead = true)
            } else {
                it
            }
        }
    }
    class NotificationViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NotificationViewModel() as T
        }
    }
}