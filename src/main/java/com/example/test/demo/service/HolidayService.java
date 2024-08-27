package com.example.test.demo.service;

import com.example.test.demo.CountryCode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    private static final String API_URL = "https://date.nager.at/Api/v2/PublicHolidays/2024/{countryCode}";

    private List<Map<String, Object>> getAllHolidays(String countryCode) throws Exception {
        String url = API_URL.replace("{countryCode}", countryCode);

        // Create HttpClient
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Create HTTP GET request
            HttpGet httpGet = new HttpGet(url);

            // Execute request
            HttpResponse response = httpClient.execute(httpGet);

            // Read response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }

                // Parse JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(json.toString(), new TypeReference<List<Map<String, Object>>>() {});
            }
        }
    }

    public List<Map<String, Object>> getHolidayForNextNDays(String countryCode, Integer NDays) throws Exception {
//        String countryCodes = CountryCode.fromKey(countryCode).toString();
        List<Map<String, Object>> holidaysList =  getAllHolidays(countryCode);

        LocalDate today = LocalDate.now();
        LocalDate oneWeekLater = today.plusDays(NDays);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Map<String, Object>> upcomingHolidays = holidaysList.stream()
                .filter(map -> {
                    String dateStr = (String) map.get("date");
                    LocalDate holidayDate = LocalDate.parse(dateStr, formatter);
                    return (holidayDate.isAfter(today.minusDays(1)) && holidayDate.isBefore(oneWeekLater.plusDays(1)));
                })
                .collect(Collectors.toList());

        return upcomingHolidays;


    }
}
