package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Getter;

@Getter
public class GetClientResponse extends SuccessfullResponse {

    private final Client client;

    public GetClientResponse(Client client) {
        this.client = client;
        setMessage("Client found successfully");
    }
}
