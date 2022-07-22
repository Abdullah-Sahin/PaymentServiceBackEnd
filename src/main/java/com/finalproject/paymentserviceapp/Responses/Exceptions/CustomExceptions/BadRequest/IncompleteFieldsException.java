package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import lombok.Getter;

@Getter
public class IncompleteFieldsException extends CustomBadRequestException{

    public IncompleteFieldsException() {
        setMessage("All fields must be completed");
    }
}
