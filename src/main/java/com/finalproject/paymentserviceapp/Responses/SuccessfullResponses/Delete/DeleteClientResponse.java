package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Delete;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;


@Data
public class DeleteClientResponse extends SuccessfullResponse {

    private Client client;

    public DeleteClientResponse(Client client) {
        this.client = client;
        setMessage("Client has been deleted");
    }
}
