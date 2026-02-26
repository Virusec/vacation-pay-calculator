package com.example.vacationpay.service;

import com.example.vacationpay.Query;
import com.example.vacationpay.Response;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

        System.out.println(salaryPerDay);

        int payableDays = vacationDaysCounterContext.countPayableVacationDays(query);

        System.out.println(payableDays);

        BigDecimal amount = salaryPerDay.multiply(BigDecimal.valueOf(payableDays));

        System.out.println("amount = " + amount);

        response.setAmount(amount);
        response.setAverageSalary(salaryPerDay);
        return response;
    }
}
