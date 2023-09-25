package org.donnguk.jjoin.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.donnguk.jjoin.base.viewmodel.BaseViewModel
import org.donnguk.jjoin.main.model.Calender
import org.donnguk.jjoin.main.model.CalenderDay
import org.donnguk.jjoin.main.model.ScheduleCard
import org.donnguk.jjoin.main.util.CalenderUtil
import java.time.LocalDate

class CalenderViewModel: BaseViewModel() {
    private val _calender = MutableLiveData<Calender>()
    val calender: LiveData<Calender> = _calender

    private val _calenderDays = MutableLiveData<List<CalenderDay>>()
    val calenderDays: LiveData<List<CalenderDay>> = _calenderDays

    private val _scheduleCards = MutableLiveData<List<ScheduleCard>>()
    val scheduleCards: LiveData<List<ScheduleCard>> = _scheduleCards

    init {
        _calender.value = Calender(
            date = LocalDate.now(),
            isExpand = false,
        )
        _calenderDays.value = CalenderUtil.daysInWeekArray(_calender.value!!.date)

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
            ),
        )
    }

    fun onClickPrevious() {
        _calender.value = if (_calender.value!!.isExpand) {
            _calender.value!!.copy(
                date = _calender.value!!.date.minusMonths(1),
            )
        } else {
            _calender.value!!.copy(
                date = _calender.value!!.date.minusWeeks(1),
            )
        }

        changeCalenderDays()
    }

    fun onClickNext() {
        _calender.value = if (_calender.value!!.isExpand) {
            _calender.value!!.copy(
                date = _calender.value!!.date.plusMonths(1),
            )
        } else {
            _calender.value!!.copy(
                date = _calender.value!!.date.plusWeeks(1),
            )
        }

        changeCalenderDays()
    }

    fun agreeSchedule(id: Int, isAgree: Boolean) {
    }

    fun changeExpand() {
        _calender.value = _calender.value!!.copy(
            isExpand = !_calender.value!!.isExpand,
        )

        changeCalenderDays()
    }

    private fun changeCalenderDays() {
        _calenderDays.value = if (_calender.value!!.isExpand)
            CalenderUtil.daysInMonthArray(_calender.value!!.date)
        else
            CalenderUtil.daysInWeekArray(_calender.value!!.date)
    }

    class CalenderViewModelFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CalenderViewModel() as T
        }
    }
}