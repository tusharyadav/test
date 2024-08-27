package com.example.test.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptions  extends Exception{

    private int code;
    private String message;
    private String causes;

    public CustomExceptions(int code, String message, String cause) {
        this.code = code;
        this.message = message;
        this.causes = cause;
    }
//    public CustomExceptions(String message) {
//        super(message);
//    }
}
