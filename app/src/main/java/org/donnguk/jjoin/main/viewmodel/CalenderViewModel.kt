package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.main.model.Calender
import org.donnguk.jjoin.main.model.CalenderDay
import org.donnguk.jjoin.main.util.CalenderUtil
import java.time.LocalDate

class CalenderViewModel: BaseViewModel() {
    private val _calender = MutableLiveData<Calender>()
    val calender: LiveData<Calender> = _calender
    private val _calenderDays = MutableLiveData<List<CalenderDay>>()
    val calenderDays: LiveData<List<CalenderDay>> = _calenderDays

    init {
        _calender.value = Calender(
            date = LocalDate.now(),
            isExpand = false,
        )

        _calenderDays.value = CalenderUtil.daysInMonthArray(_calender.value!!.date)
    }

    fun onClickPrevious() {

    }

    fun onClickNext() {

    }
    class CalenderViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CalenderViewModel() as T
        }
    }
}