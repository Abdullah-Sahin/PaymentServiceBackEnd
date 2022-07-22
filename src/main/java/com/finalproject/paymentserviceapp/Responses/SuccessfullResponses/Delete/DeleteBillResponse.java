package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Delete;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

@Data
public class DeleteBillResponse extends SuccessfullResponse {
    private Bill bill;

    public DeleteBillResponse(Bill bill) {
        this.bill = bill;
        setMessage("Bill has been deleted ");
    }
}
