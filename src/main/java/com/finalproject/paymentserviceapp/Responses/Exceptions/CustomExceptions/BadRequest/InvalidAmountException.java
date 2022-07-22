package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import lombok.Getter;

@Getter
public class InvalidAmountException extends CustomBadRequestException{
    public InvalidAmountException() {
        setMessage("Amount cannot be negative");
    }
}
