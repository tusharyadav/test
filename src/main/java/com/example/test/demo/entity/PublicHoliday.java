package com.example.test.demo.entity;

import com.example.test.demo.CountryCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PublicHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CountryCode location;

    @Column(nullable = false)
    private LocalDate holidayDate;

    @Column(nullable = false)
    private String holidayName;

    @Column(nullable = false)
    private String description;

    // Getters and Setters
}
