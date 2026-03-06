package com.example.vacationpay;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Anatoliy Shikin
 */
@Data
public class Response {
    private BigDecimal averageSalary;
    private BigDecimal amount;
    private Integer vacationDaysRequested;
    private Integer payableDays;
}
