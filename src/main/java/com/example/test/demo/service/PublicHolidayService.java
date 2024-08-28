package com.example.test.demo.service;

import com.example.test.demo.CountryCode;
import com.example.test.demo.entity.Employee;
import com.example.test.demo.entity.PublicHoliday;
import com.example.test.demo.exceptions.CustomExceptions;
import com.example.test.demo.request.PublicHolidayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PublicHolidayService {

//    @Autowired
//    private PublicHolidayRepository publicHolidayRepository;

    @Autowired
    private CommonService commonService;

    @Autowired
    private HolidayService holidayService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmployeeService employeeService;

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

    @Scheduled(cron = "0 0 9 * * ?")  // Schedule to run every day at 9 AM
    public void sendHolidayAlerts() throws Exception {
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            List<Map<String, Object>> holidays = holidayService.getHolidayForNextNDays(employee.getCountryCode(), 7);

            if (!holidays.isEmpty()) {
                String subject = "Upcoming Public Holidays for the Next 7 Days";
                String text = buildHolidayAlertMessage(holidays);

                emailService.sendHolidayAlert(employee.getEmail(), subject, text);
            }
        }
    }

    private String buildHolidayAlertMessage(List<Map<String, Object>> holidays) {
        return holidays.stream()
                .map(holiday -> "Date: " + holiday.get("date") + "\n" +
                        "Name: " + holiday.get("name") + "\n" +
                        "Local Name: " + holiday.get("localName") + "\n" +
                        "Country: " + holiday.get("countryCode") + "\n\n")
                .collect(Collectors.joining());
    }

}
