package com.example.vacationpay.service.strategy;

import com.example.vacationpay.Query;

/**
 * @author Anatoliy Shikin
 */
public interface VacationDaysCountingStrategy {
    boolean supports(Query query);
    int countPayableVacationDays(Query query);
}
