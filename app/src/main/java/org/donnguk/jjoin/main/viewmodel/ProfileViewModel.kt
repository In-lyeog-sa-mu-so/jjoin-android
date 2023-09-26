package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.main.model.JoinedClub

class ProfileViewModel: BaseViewModel() {
    private val _joinedClubs = MutableLiveData<List<JoinedClub>>()
    val joinedClubs: LiveData<List<JoinedClub>> = _joinedClubs

    init {
        _joinedClubs.value = listOf(
            JoinedClub(
                id = 1,
                title = "동국대학교 컴퓨터공학과 학생회"
            ),
            JoinedClub(
                id = 2,
                title = "세미콜론"
            ),
            JoinedClub(
                id = 3,
                title = "멋쟁이 사자처럼"
            ),
            JoinedClub(
                id = 4,
                title = "동국대학교 컴퓨터공학과 학생회"
            ),
            JoinedClub(
                id = 5,
                title = "세미콜론"
            ),
            JoinedClub(
                id = 6,
                title = "멋쟁이 사자처럼"
            ),
            JoinedClub(
                id = 7,
                title = "동국대학교 컴퓨터공학과 학생회"
            ),

        )
    }

    class ProfileViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProfileViewModel() as T
        }
    }
}