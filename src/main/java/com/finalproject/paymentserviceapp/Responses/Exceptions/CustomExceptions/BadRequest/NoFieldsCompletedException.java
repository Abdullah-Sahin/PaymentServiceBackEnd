package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import lombok.Getter;

@Getter
public class NoFieldsCompletedException extends CustomBadRequestException{

    public NoFieldsCompletedException() {
        setMessage("No field supplied to be updated");
    }
}
