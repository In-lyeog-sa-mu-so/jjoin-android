package org.donnguk.jjoin.club.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.BaseViewModel
import org.donnguk.jjoin.club.model.Club
import org.donnguk.jjoin.club.model.ClubImage
import java.time.LocalDate

class ClubDetailViewModel: BaseViewModel() {
    private val _clubImage = MutableLiveData<ClubImage>()
    val clubImage: LiveData<ClubImage> = _clubImage

    private val _club = MutableLiveData<Club>()
    val club: LiveData<Club> = _club

    init {
        _club.value = Club(
            id = 1,
            name = "FC 세미콜론",
            tags = "#축구 #운동 #동아리",
            description = " 안녕하세요! 동국대학교 컴퓨터 공학과 소모임 FC 세미콜론입니다.\n" +
                    " 1달에 4-6회씩 축구, 풋살을 하며 학교 정기 대회도 출전할 계획입니다. \n" +
                    "많은 관심 부탁드립니다!",
            leader = "박재형",
            memberNum = "107명",
            openDate = LocalDate.now(),
            department = "학과"
        )
    }

    class ClubDetailViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ClubDetailViewModel() as T
        }
    }
}