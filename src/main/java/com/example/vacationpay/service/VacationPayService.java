package com.example.vacationpay.service;

import com.example.vacationpay.Query;
import com.example.vacationpay.Response;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Anatoliy Shikin
 */
@Service
public class VacationPayService {
    private final BigDecimal AVERAGE_MONTHLY_NUMBER_OF_CALENDAR_DAY = new BigDecimal("29.3");
    private final VacationDaysCounterContext vacationDaysCounterContext;

    public VacationPayService(VacationDaysCounterContext vacationDaysCounterContext) {
        this.vacationDaysCounterContext = vacationDaysCounterContext;
    }

    public Response calculate(Query query) {
        Response response = new Response();
        BigDecimal salaryPerDay = query.getAverageSalary()
                .divide(AVERAGE_MONTHLY_NUMBER_OF_CALENDAR_DAY, 2, RoundingMode.HALF_UP);
        int payableDays = vacationDaysCounterContext.countPayableVacationDays(query);
        BigDecimal amount = salaryPerDay.multiply(BigDecimal.valueOf(payableDays));
        Integer requestedDays = getRequestedDays(query);

        response.setAmount(amount);
        response.setAverageSalary(salaryPerDay);
        response.setPayableDays(payableDays);
        response.setVacationDaysRequested(requestedDays);
        return response;
    }

    private Integer getRequestedDays(Query query) {
        if (query.getVacationDays() != null) {
            return query.getVacationDays();
        }
        LocalDate start = query.getStartDate();
        LocalDate end = query.getEndDate();
        return (int) ChronoUnit.DAYS.between(start, end) + 1;
    }
}
