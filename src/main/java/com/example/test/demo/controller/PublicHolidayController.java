package com.example.test.demo.controller;

import com.example.test.demo.CountryCode;
import com.example.test.demo.entity.Holiday;
import com.example.test.demo.entity.PublicHoliday;
import com.example.test.demo.exceptions.CustomExceptions;
import com.example.test.demo.request.PublicHolidayRequest;
import com.example.test.demo.service.HolidayService;
import com.example.test.demo.service.PublicHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/holidays")
public class PublicHolidayController {

    @Autowired
    private PublicHolidayService publicHolidayService;

    @Autowired
    private HolidayService holidayService;

//    @GetMapping("/{locationName}")
//    public List<PublicHoliday> getHolidays(@PathVariable CountryCode locationName) throws CustomExceptions {
//        return publicHolidayService.getPublicHolidaysForNext7Days(locationName);
//    }

//    @PostMapping
//    public ResponseEntity<PublicHoliday> addPublicHoliday(@RequestBody PublicHolidayRequest request) throws CustomExceptions {
//
//        PublicHoliday savedHoliday = publicHolidayService.addPublicHoliday(request);
//
//        return new ResponseEntity<>(savedHoliday, HttpStatus.CREATED);
//    }


    @GetMapping
    public List<Map<String, Object>> getScrapHolidays(@RequestParam String countryCode) {
        Integer days = 7;
        try {
            return holidayService.getHolidayForNextNDays(countryCode,days);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch holidays");
        }

    }

}
