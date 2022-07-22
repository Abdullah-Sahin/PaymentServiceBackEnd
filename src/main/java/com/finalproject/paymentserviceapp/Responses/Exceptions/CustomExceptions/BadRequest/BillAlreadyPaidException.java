package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest;

import lombok.Getter;

@Getter
public class BillAlreadyPaidException extends CustomBadRequestException{

    public BillAlreadyPaidException() {
        setMessage("Bill was already paid. No updates available");
    }
}
