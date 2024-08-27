package com.example.test.demo.request;

import com.example.test.demo.CountryCode;
import lombok.Data;
import lombok.NonNull;

@Data
public class EmployeeRequest {
    private String name;
    private String position;
    private String email;
    private Float salary;
    private CountryCode location;
}
