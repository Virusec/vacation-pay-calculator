package com.example.vacationpay;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
@Data
public class Query {
    @NotNull
    @Min(0)
    private BigDecimal averageSalary;
    @Positive
    private Integer vacationDays;
    @DateTimeFormat
    private LocalDate startDate;
    @DateTimeFormat
    private LocalDate endDate;
}
