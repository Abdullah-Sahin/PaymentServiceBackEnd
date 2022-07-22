package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class CustomException extends Exception {

    private String message;
    private HttpStatus httpStatus;

}
