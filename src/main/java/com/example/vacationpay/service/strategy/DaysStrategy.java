package com.example.vacationpay.service.strategy;

import com.example.vacationpay.Query;
import org.springframework.stereotype.Component;

/**
 * @author Anatoliy Shikin
 */
@Component
public class DaysStrategy implements VacationDaysCountingStrategy{
    @Override
    public boolean supports(Query query) {
        return query.getVacationDays() != null
                && query.getStartDate() == null
                && query.getEndDate() == null;
    }

    @Override
    public int countPayableVacationDays(Query query) {
        return query.getVacationDays();
    }
}
