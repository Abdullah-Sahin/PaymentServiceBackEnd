package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import lombok.Getter;

@Getter
public class PaymentForClientAlreadyExistsException extends CustomBadRequestException{
    public PaymentForClientAlreadyExistsException(Long paymentId) {
        setMessage("A payment already exists for client with clientId: " + paymentId);
    }
}
