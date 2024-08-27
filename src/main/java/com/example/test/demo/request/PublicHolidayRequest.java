package com.example.test.demo.request;

import com.example.test.demo.CountryCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PublicHolidayRequest {
    @NonNull
    private CountryCode locationString;
    @NonNull
    private LocalDate date;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
