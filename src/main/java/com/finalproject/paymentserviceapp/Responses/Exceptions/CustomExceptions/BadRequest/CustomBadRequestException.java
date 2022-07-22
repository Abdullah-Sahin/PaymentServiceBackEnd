package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.CustomException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomBadRequestException extends CustomException {

    public CustomBadRequestException() {
        setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
