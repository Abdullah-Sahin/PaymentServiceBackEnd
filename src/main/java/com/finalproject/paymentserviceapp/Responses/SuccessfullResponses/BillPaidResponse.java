package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import lombok.Getter;

@Getter
public class BillPaidResponse extends SuccessfullResponse{

    private final Bill bill;
    public BillPaidResponse(Bill bill) {
        this.bill = bill;
        setMessage("Payment has successfully been made.");
    }
}
