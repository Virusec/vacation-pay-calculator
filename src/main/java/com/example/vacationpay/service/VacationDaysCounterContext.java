package com.example.vacationpay.service;

import com.example.vacationpay.Query;
import com.example.vacationpay.service.strategy.VacationDaysCountingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Anatoliy Shikin
 */
@Component
public class VacationDaysCounterContext {
    private final List<VacationDaysCountingStrategy> strategies;

    public VacationDaysCounterContext(List<VacationDaysCountingStrategy> strategies) {
        this.strategies = strategies;
    }
    public int countPayableVacationDays(Query query) {
        for (VacationDaysCountingStrategy strategy : strategies) {
            if (strategy.supports(query)) {
                return strategy.countPayableVacationDays(query);
            }
        }
        throw new IllegalArgumentException("No strategy found for query: " + query);
    }
}
