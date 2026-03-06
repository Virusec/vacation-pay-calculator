package com.example.vacationpay.service.holiday;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

/**
 * @author Anatoliy Shikin
 */
@Component
public class RussianHolidayCalendar implements HolidayCalendar {
    private static final Set<MonthDay> FIXED_HOLIDAYS_2026 = Set.of(
            MonthDay.of(Month.JANUARY, 1),
            MonthDay.of(Month.JANUARY, 2),
            MonthDay.of(Month.JANUARY, 5),
            MonthDay.of(Month.JANUARY, 6),
            MonthDay.of(Month.JANUARY, 7),
            MonthDay.of(Month.JANUARY, 8),
            MonthDay.of(Month.JANUARY, 9),
            MonthDay.of(Month.FEBRUARY, 23),
            MonthDay.of(Month.MARCH, 9),
            MonthDay.of(Month.MAY, 1),
            MonthDay.of(Month.MAY, 11),
            MonthDay.of(Month.JUNE, 12),
            MonthDay.of(Month.NOVEMBER, 4),
            MonthDay.of(Month.DECEMBER, 31)
    );

    @Override
    public boolean isHoliday(LocalDate date) {
        return FIXED_HOLIDAYS_2026.contains(MonthDay.from(date));
    }
}
