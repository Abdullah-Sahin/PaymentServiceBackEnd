package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound;

import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.CustomException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomNotFoundException extends CustomException {

    public CustomNotFoundException() {
        setHttpStatus(HttpStatus.NOT_FOUND);
    }
}
