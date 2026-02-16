package com.example.vacationpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.StringBufferInputStream;

@SpringBootApplication
public class VacationPayCalculatorApplication {

    public static void main(String[] args) {
        System.out.println("Java runtime = " + System.getProperty("java.runtime.version"));
        SpringApplication.run(VacationPayCalculatorApplication.class, args);
    }

}
