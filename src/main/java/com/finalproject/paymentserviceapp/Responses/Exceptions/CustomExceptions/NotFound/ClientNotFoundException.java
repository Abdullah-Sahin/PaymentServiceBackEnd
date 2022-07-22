package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound;

import lombok.Getter;

@Getter
public class ClientNotFoundException extends CustomNotFoundException {

    public ClientNotFoundException(Long clientId) {
        setMessage("there is no client with supplied clientId: " +clientId);
    }
}
