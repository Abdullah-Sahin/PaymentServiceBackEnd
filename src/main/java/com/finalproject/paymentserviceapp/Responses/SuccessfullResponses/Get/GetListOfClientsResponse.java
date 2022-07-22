package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetListOfClientsResponse extends SuccessfullResponse {

    private List<Client> clients;

    public GetListOfClientsResponse(List<Client> clients) {
        this.clients = clients;
        setMessage("Clients found");
    }
}
