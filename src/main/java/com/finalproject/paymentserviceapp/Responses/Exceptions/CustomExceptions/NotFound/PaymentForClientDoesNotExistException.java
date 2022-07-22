package com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import lombok.Getter;

@Getter
public class PaymentForClientDoesNotExistException extends CustomNotFoundException{

    public PaymentForClientDoesNotExistException(Client client){
        setMessage("Payment does not exists for client: " + client);
    }
}
