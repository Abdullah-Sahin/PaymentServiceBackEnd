package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Create;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

@Data
public class CreateClientResponse extends SuccessfullResponse {

    private Client client;

    public CreateClientResponse(Client client) {
        this.client = client;
        setMessage("Client has been added successfully");
    }
}
