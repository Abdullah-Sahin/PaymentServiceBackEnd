package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound;

import lombok.Getter;

@Getter
public class BillNotFoundException extends CustomNotFoundException {

    public BillNotFoundException(Long billId) {
        setMessage("Bill not found with supplied billId: " + billId);
    }
}
