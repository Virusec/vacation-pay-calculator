package com.example.vacationpay;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Anatoliy Shikin
 */
@Service
public class VacationPayService {
    private final BigDecimal AVERAGE_MONTHLY_NUMBER_OF_CALENDAR_DAY = new BigDecimal("29.3");

    public Response calculate(Query query) {
        Response response = new Response();
        BigDecimal vacationPayAmount = (query.getAverageSalary()
                .divide(AVERAGE_MONTHLY_NUMBER_OF_CALENDAR_DAY, 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(query.getVacationDays())));
        response.setAmount(vacationPayAmount);
        response.setAverageSalary(query.getAverageSalary());
        return response;
    }
}
