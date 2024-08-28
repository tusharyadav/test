package com.example.test.demo.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class ErrorResponse {
    private int status;
    private String message;
    private String description;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, String description, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.description = description;
    }


}
