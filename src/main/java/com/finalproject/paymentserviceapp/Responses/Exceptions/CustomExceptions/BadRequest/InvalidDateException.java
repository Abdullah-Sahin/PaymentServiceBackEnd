package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import lombok.Getter;

@Getter
public class InvalidDateException extends CustomBadRequestException{
    public InvalidDateException() {
        setMessage("Bills cannot be formed for future date");
    }
}
