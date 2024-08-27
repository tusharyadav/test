package com.example.test.demo.utility;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    private static final ZoneId REMOTE_TIMEZONE = ZoneId.of("UTC"); // Simulate remote server timezone
    private static final ZoneId LOCAL_TIMEZONE = ZoneId.systemDefault(); // Local timezone of the client

    // Converts the remote datetime to local datetime
    public static LocalDateTime convertToLocalTime(LocalDateTime remoteDateTime) {
        ZonedDateTime remoteZonedDateTime = remoteDateTime.atZone(REMOTE_TIMEZONE);
        ZonedDateTime localZonedDateTime = remoteZonedDateTime.withZoneSameInstant(LOCAL_TIMEZONE);
        return localZonedDateTime.toLocalDateTime();
    }

    // Format the datetime for display (optional)
    public static String formatDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
