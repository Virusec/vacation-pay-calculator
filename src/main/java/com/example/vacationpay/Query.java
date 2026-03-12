package com.example.vacationpay;

import jakarta.validation.constraints.DecimalMin;
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
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal averageSalary;
    @Positive
    private Integer vacationDays;
    @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
}
