package com.example.test.demo.entity;

import com.example.test.demo.CountryCode;
import com.example.test.demo.utility.TimeZoneConverter;
import jakarta.persistence.*;

//import javax.persistence.*;
import java.util.UUID;

import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data

//@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID employeeId;

    String name;

//    @NonNull
    String position;

//    @NonNull
    String email;

//    @NonNull
    float salary;

//    @NonNull
    LocalDateTime createdAt;

//    @NonNull
    LocalDateTime modifiedAt;

    @Enumerated(EnumType.STRING)
    private CountryCode location;

    public LocalDateTime getCreatedAtLocal() {
        return TimeZoneConverter.convertToLocalTime(createdAt);
    }

    public String getFormattedCreatedAt() {
        return TimeZoneConverter.formatDateTime(getCreatedAtLocal());
    }

    public LocalDateTime getModifiedAtLocal() {
        return TimeZoneConverter.convertToLocalTime(modifiedAt);
    }

    public String getFormattedModifiedAt() {
        return TimeZoneConverter.formatDateTime(getModifiedAtLocal());
    }


    public String getCountryCode() {
        return location.toString();
    }
}
