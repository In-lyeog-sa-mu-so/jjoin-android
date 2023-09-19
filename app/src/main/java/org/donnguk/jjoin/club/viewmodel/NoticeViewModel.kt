package org.donnguk.jjoin.club.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.club.model.Notice
import java.time.LocalDate

class NoticeViewModel: BaseViewModel() {
    private val _notices = MutableLiveData<List<Notice>>()
    val notices: LiveData<List<Notice>> = _notices

    init {
        _notices.value = listOf(
            Notice(
                id = 1,
                title = "공지사항1",
                content = "공지사항1 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 2,
                title = "공지사항2",
                content = "공지사항2 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 3,
                title = "공지사항3",
                content = "공지사항3 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 4,
                title = "공지사항4",
                content = "공지사항4 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 5,
                title = "공지사항5",
                content = "공지사항5 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 6,
                title = "공지사항6",
                content = "공지사항6 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 7,
                title = "공지사항7",
                content = "공지사항7 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 8,
                title = "공지사항8",
                content = "공지사항8 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 9,
                title = "공지사항9",
                content = "공지사항9 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
            Notice(
                id = 10,
                title = "공지사항10",
                content = "공지사항10 내용",
                updateDate = LocalDate.of(2021, 9, 1)
            ),
        )
    }


    class NoticeViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NoticeViewModel() as T
        }
    }
}