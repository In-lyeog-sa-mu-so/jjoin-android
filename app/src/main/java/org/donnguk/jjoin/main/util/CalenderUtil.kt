package org.donnguk.jjoin.main.util

import org.donnguk.jjoin.main.model.CalenderDay
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.time.temporal.WeekFields


object CalenderUtil {
    fun getCurrentWeekOfMonth(date: LocalDate): String {
        val weekFields: WeekFields = WeekFields.of(DayOfWeek.SUNDAY, 4)

        val weekOfMonth: Int = date.get(weekFields.weekOfMonth())

        if (weekOfMonth == 0) {
            val lastDayOfLastMonth: LocalDate =
                date.with(TemporalAdjusters.firstDayOfMonth()).minusDays(1)
            return getCurrentWeekOfMonth(lastDayOfLastMonth)
        }

        val lastDayOfMonth: LocalDate = date.with(TemporalAdjusters.lastDayOfMonth())

        if (weekOfMonth == lastDayOfMonth.get(weekFields.weekOfMonth())
            && lastDayOfMonth.dayOfWeek < DayOfWeek.THURSDAY) {
            val firstDayOfNextMonth: LocalDate =
                date.with(TemporalAdjusters.lastDayOfMonth()).plusDays(1)
            return getCurrentWeekOfMonth(firstDayOfNextMonth)
        }

        return "${date.year}년 ${date.monthValue}월 ${weekOfMonth}주차"
    }

    @Deprecated("Use getFormattedDayFromDate instead")
    // 입력받은 날짜에 대하여 해당 달의 날짜 리스트를 반환, 이때 해당 날짜의 정보를 담은 DayState를 반환
    // 또한, 이전 달의 날짜와 다음 달의 날짜를 포함하여 42개의 날짜를 반환(null 값 없이)
    fun daysInMonthArray(date: LocalDate): List<CalenderDay> {
        val daysInMonthArray = mutableListOf<CalenderDay>()
        val yearMonth = YearMonth.from(date)
        val firstDayOfMonth = date.withDayOfMonth(1)
        val lastDayOfMonth = date.withDayOfMonth(yearMonth.lengthOfMonth())

        val previousMonth = date.minusMonths(1)
        val nextMonth = date.plusMonths(1)

        // 이전 달의 날짜 추가
        val previousMonthLength = YearMonth.of(previousMonth.year, previousMonth.month).lengthOfMonth()
        val previousMonthStartDay = previousMonthLength - firstDayOfMonth.dayOfWeek.value + 2
        for (i in previousMonthStartDay - 1..previousMonthLength) {
            daysInMonthArray.add(
                CalenderDay(
                    date = LocalDate.of(previousMonth.year, previousMonth.month, i),
                    isSelect = false,
                    existInMonth = false,
                    clubs = when (val mod = i % 3) {
                        0 -> listOf("1", "2", "3")
                        1 -> listOf("1", "2", "")
                        else -> listOf("1", "", "")
                    }
                )
            )
        }

        // 현재 달의 날짜 추가
        for (i in 1..lastDayOfMonth.dayOfMonth) {
            daysInMonthArray.add(
                CalenderDay(
                    date = LocalDate.of(date.year, date.month, i),
                    isSelect = date.dayOfMonth == i,
                    existInMonth = true,
                    clubs = when (val mod = i % 3) {
                        0 -> listOf("1", "2", "3")
                        1 -> listOf("1", "2", "")
                        else -> listOf("1", "", "")
                    }
                )
            )
        }

        // 다음 달의 날짜 추가
        val daysToAdd = 42 - daysInMonthArray.size
        for (i in 1..daysToAdd) {
            daysInMonthArray.add(
                CalenderDay(
                    date = LocalDate.of(nextMonth.year, nextMonth.month, i),
                    isSelect = false,
                    existInMonth = false,
                    clubs = when (val mod = i % 3) {
                        0 -> listOf("1", "2", "3")
                        1 -> listOf("1", "2", "")
                        else -> listOf("1", "", "")
                    }
                )
            )
        }

        return daysInMonthArray
    }

    @Deprecated("Use daysInWeekArray instead")
    fun daysInWeekArray(date: LocalDate): List<CalenderDay> {
        val startOfWeek = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
        val endOfWeek = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))

        val daysOfWeek = mutableListOf<CalenderDay>()
        var currentDate = startOfWeek

        while (!currentDate.isAfter(endOfWeek)) {
            daysOfWeek.add(
                CalenderDay(
                    date = currentDate,
                    isSelect = false,
                    existInMonth = true,
                    clubs = listOf()
                )
            )
            currentDate = currentDate.plusDays(1)
        }

        return daysOfWeek
    }
}

