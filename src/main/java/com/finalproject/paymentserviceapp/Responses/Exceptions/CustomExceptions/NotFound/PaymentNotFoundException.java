package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound;

import lombok.Getter;

@Getter
public class PaymentNotFoundException extends CustomNotFoundException {
    public PaymentNotFoundException(Long paymentId) {
        setMessage("Payment not found with supplied paymentId: " + paymentId);
    }
}
