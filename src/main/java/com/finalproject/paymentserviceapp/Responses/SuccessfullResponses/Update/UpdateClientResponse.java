package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Update;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Getter;

@Getter
public class UpdateClientResponse extends SuccessfullResponse {

    private final Client client;

    public UpdateClientResponse(Client client) {
        this.client = client;
        setMessage("Client has been updated successfully");
    }
}
