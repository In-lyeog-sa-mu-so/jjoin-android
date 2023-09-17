package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.BaseViewModel
import org.donnguk.jjoin.main.model.AccededClubCard
import org.donnguk.jjoin.main.model.ClubCard
import org.donnguk.jjoin.main.model.ScheduleCard

class HomeViewModel: BaseViewModel() {
    private val _accededClubCards = MutableLiveData<List<AccededClubCard>>()
    val accededClubCards: LiveData<List<AccededClubCard>> = _accededClubCards

    private val _scheduleCards = MutableLiveData<List<ScheduleCard>>()
    val scheduleCards: LiveData<List<ScheduleCard>> = _scheduleCards

    private val _clubCards = MutableLiveData<List<ClubCard>>()
    val clubCards: LiveData<List<ClubCard>> = _clubCards

    init {
        _accededClubCards.value = listOf(
            AccededClubCard(
                id = 1,
                title = "동국대학교 컴퓨터공학과 학생회",
                description = "동국대학교 컴퓨터공학과 학생회입니다.",
                leaderName = "김태욱",
                number = 38,
                department = "학과",
                recentNotice = "2023년 할로윈 파티 일일호프 행사 관련 준비 공지"
            ),
            AccededClubCard(
                id = 2,
                title = "동국대학교 컴퓨터공학과 학생회",
                description = "동국대학교 컴퓨터공학과 학생회입니다.",
                leaderName = "김태욱",
                number = 38,
                department = "학과",
                recentNotice = "2023년 할로윈 파티 일일호프 행사 관련 준비 공지"
            ),
            AccededClubCard(
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

        _clubCards.value = listOf(
            ClubCard(
                id = 4,
                title = "멋쟁이 사자처럼",
                description = "누구보다 빛나게! 멋쟁이 사자처럼!",
                number = 105,
                department = "연합",
                tag = "#코딩 #프로젝트"
            ),
            ClubCard(
                id = 5,
                title = "멋쟁이 사자처럼",
                description = "누구보다 빛나게! 멋쟁이 사자처럼!",
                number = 105,
                department = "연합",
                tag = "#코딩 #프로젝트"
            ),
            ClubCard(
                id = 6,
                title = "멋쟁이 사자처럼",
                description = "누구보다 빛나게! 멋쟁이 사자처럼!ㅇㅇㅇㅇㅇㅇㅇ",
                number = 105,
                department = "연합",
                tag = "#코딩 #프로젝트"
            ),
        )
    }

    class HomeViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel() as T
        }
    }
}