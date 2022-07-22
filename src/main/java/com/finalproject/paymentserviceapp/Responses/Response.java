package com.finalproject.paymentserviceapp.Responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class Response {
    private int responseCode;
    private String message;
    private LocalDate date;
    private HttpStatus status;

    public Response(){
        this.date = LocalDate.now();
    }
}
