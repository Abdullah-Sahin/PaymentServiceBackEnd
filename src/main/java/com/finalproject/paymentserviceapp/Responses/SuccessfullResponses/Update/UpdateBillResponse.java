package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Update;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Getter;

@Getter
public class UpdateBillResponse extends SuccessfullResponse {
    private final Bill bill;
    public UpdateBillResponse(Bill bill) {
        this.bill = bill;
        setMessage("Bill has been updated");
    }
}
