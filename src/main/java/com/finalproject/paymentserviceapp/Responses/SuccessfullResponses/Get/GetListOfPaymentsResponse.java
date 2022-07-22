package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get;

import com.finalproject.paymentserviceapp.Layers.Entities.Payment;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetListOfPaymentsResponse extends SuccessfullResponse {

    private List paymentList;

    public GetListOfPaymentsResponse(List<Payment> paymentList) {
        this.paymentList = paymentList;
        setMessage("Payments found");
    }
}
