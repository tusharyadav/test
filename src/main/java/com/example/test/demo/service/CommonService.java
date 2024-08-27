package com.example.test.demo.service;

import com.example.test.demo.CountryCode;
import com.example.test.demo.exceptions.CustomExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommonService {

//    @Autowired
//    private LocationRepository locationRepository;


//    CountryCode getOrSaveLocation(CountryCode locationString) throws CustomExceptions {

//        if(locationString == null) throw new CustomExceptions(408,"location is empty", "add value to location");
//
//        Optional<Location> optionalLocation = locationRepository.findByName(locationString);
//
//        // Get the Location object, or create a new one if it doesn't exist
//        CountryCode location = CountryCode.AFGHANISTAN;
//        if (optionalLocation.isPresent()) {
//            location = optionalLocation.get().getCountryCode();
//        } else {
//            // Create and save a new Location
////            location = new Location(locationString); // Assuming the constructor is Location(Long id, String name)
////            locationRepository.save(location);
//        }


//    }
}
