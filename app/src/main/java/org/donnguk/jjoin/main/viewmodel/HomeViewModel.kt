package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.viewpharm.yakal.base.BaseViewModel
import org.donnguk.jjoin.main.model.ClubCard
import org.donnguk.jjoin.main.model.ScheduleCard

class HomeViewModel: BaseViewModel() {
    private val _clubCards = MutableLiveData<List<ClubCard>>()
    val clubCards: LiveData<List<ClubCard>> = _clubCards

    private val _scheduleCards = MutableLiveData<List<ScheduleCard>>()
    val scheduleCards: LiveData<List<ScheduleCard>> = _scheduleCards

    init {
        _clubCards.value = listOf(
            ClubCard(
                id = 1,
                title = "동국대학교 컴퓨터공학과 학생회",
                description = "동국대학교 컴퓨터공학과 학생회입니다.",
                leaderName = "김태욱",
                number = 38,
                department = "학과",
                recentNotice = "2023년 할로윈 파티 일일호프 행사 관련 준비 공지"
            ),
            ClubCard(
                id = 2,
                title = "동국대학교 컴퓨터공학과 학생회",
                description = "동국대학교 컴퓨터공학과 학생회입니다.",
                leaderName = "김태욱",
                number = 38,
                department = "학과",
                recentNotice = "2023년 할로윈 파티 일일호프 행사 관련 준비 공지"
            ),
            ClubCard(
                id = 3,
                title = "동국대학교 컴퓨터공학과 학생회",
                description = "동국대학교 컴퓨터공학과 학생회입니다.",
                leaderName = "김태욱",
                number = 38,
                department = "학과",
                recentNotice = "2023년 할로윈 파티 일일호프 행사 관련 준비 공지"
            )
        )

        _scheduleCards.value = listOf(
            ScheduleCard(
                id = 773,
                time = "2021.10.10 18:00",
                title = "동국대학교 컴퓨터공학과 학생회 2021년 1학기 정기총회"
            ),
            ScheduleCard(
                id = 774,
                time = "2021.10.10 18:00",
                title = "동국대학교 컴퓨터공학과 학생회 2021년 1학기 정기총회"
            ),
            ScheduleCard(
                id = 775,
                time = "2021.10.10 18:00",
                title = "동국대학교 컴퓨터공학과 학생회 2021년 1학기 정기총회"
            )
        )
    }

    class HomeViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel() as T
        }
    }
}