package org.donnguk.jjoin.club.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.club.model.Plan
import java.time.LocalDateTime

class PlanViewModel: BaseViewModel() {
    private val _plans = MutableLiveData<List<Plan>>()
    val plans: LiveData<List<Plan>> = _plans

    init {
        _plans.value = listOf(
            Plan(
                id = 1,
                title = "1차 모임",
                startDate = LocalDateTime.of(2021, 9, 1, 0, 0, 0),
                endDate = LocalDateTime.of(2021, 9, 1, 0, 0, 0),
                isAgree = true
            ),
            Plan(
                id = 2,
                title = "2차 모임",
                startDate = LocalDateTime.of(2021, 9, 1, 0, 0, 0),
                endDate = LocalDateTime.of(2021, 9, 1, 0, 0, 0),
                isAgree = false
            ),
            Plan(
                id = 3,
                title = "3차 모임",
                startDate = LocalDateTime.of(2021, 9, 1, 0, 0, 0),
                endDate = LocalDateTime.of(2021, 9, 1, 0, 0, 0),
                isAgree = null
            )
        )
    }

    class PlanViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PlanViewModel() as T
        }
    }
}