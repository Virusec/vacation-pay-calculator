package com.example.vacationpay.service.holiday;

import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
public interface HolidayCalendar {
    boolean isHoliday(LocalDate date);
}
