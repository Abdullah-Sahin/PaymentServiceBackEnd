package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Create;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

@Data
public class CreateBillResponse extends SuccessfullResponse {

    private Bill bill;

    public CreateBillResponse(Bill bill) {
        this.bill = bill;
        setMessage("Bill has been created successfully");
    }
}
