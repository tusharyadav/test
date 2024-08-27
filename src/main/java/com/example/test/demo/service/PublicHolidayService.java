package com.example.test.demo.service;

import com.example.test.demo.CountryCode;
import com.example.test.demo.entity.PublicHoliday;
import com.example.test.demo.exceptions.CustomExceptions;
import com.example.test.demo.request.PublicHolidayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicHolidayService {

//    @Autowired
//    private PublicHolidayRepository publicHolidayRepository;

    @Autowired
    private CommonService commonService;
//    private final CommonService commonService;



//    public PublicHolidayService(CommonService commonService) {
//        this.commonService = commonService;
//    }

//    public List<PublicHoliday> getPublicHolidaysForNext7Days(CountryCode locationName) throws CustomExceptions {
//        Location location = locationRepository.findByName(locationName)
//                .orElseThrow(() -> new CustomExceptions(404, "Location not found","not found"));
//
//        LocalDate today = LocalDate.now();
//        LocalDate sevenDaysLater = today.plusDays(7);
//
//        List<PublicHoliday> publicHolidays = publicHolidayRepository.findByLocationAndHolidayDateBetween(location, today, sevenDaysLater);
//
//        if(publicHolidays.isEmpty()){
//            throw new CustomExceptions(404, "No Holiday Found","not found");
//        }
//        return publicHolidays;
//    }

//    public PublicHoliday a
//    public PublicHoliday addPublicHoliday(PublicHolidayRequest request) throws CustomExceptions {
//
//        PublicHoliday publicHoliday = new PublicHoliday();
//        CountryCode location = commonService.getOrSaveLocation(request.getLocationString());
//        publicHoliday.setLocation(location); // Assuming Location is set correctly
//        publicHoliday.setHolidayDate(request.getDate());
//        publicHoliday.setHolidayName(request.getName());
//        publicHoliday.setDescription(request.getDescription());
//
//        return publicHolidayRepository.save(publicHoliday);
//    }
}
