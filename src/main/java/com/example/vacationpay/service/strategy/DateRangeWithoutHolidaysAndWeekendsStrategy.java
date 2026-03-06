package com.example.vacationpay.service.strategy;

import com.example.vacationpay.Query;
import com.example.vacationpay.service.holiday.HolidayCalendar;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
@Component
public class DateRangeWithoutHolidaysAndWeekendsStrategy implements VacationDaysCountingStrategy {
    private final HolidayCalendar holidayCalendar;

    public DateRangeWithoutHolidaysAndWeekendsStrategy(HolidayCalendar holidayCalendar) {
        this.holidayCalendar = holidayCalendar;
    }

    @Override
    public boolean supports(Query query) {
        return query.getVacationDays() == null
                && query.getStartDate() != null
                && query.getEndDate() != null;
    }

    @Override
    public int countPayableVacationDays(Query query) {
        LocalDate startDate = query.getStartDate();
        LocalDate endDate = query.getEndDate();
        int countDays = 0;
        for (LocalDate i = startDate; !i.isAfter(endDate); i = i.plusDays(1)) {
            if (holidayCalendar.isHoliday(i) || isWeekend(i)) {
                continue;
            }
            countDays++;
        }
        return countDays;
    }

    private static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
