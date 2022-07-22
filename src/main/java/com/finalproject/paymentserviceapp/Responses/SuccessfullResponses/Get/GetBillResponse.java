package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Getter;

@Getter
public class GetBillResponse extends SuccessfullResponse {

    private final Bill bill;

    public GetBillResponse(Bill bill) {
        this.bill = bill;
        setMessage("Bill found successfully");
    }
}
