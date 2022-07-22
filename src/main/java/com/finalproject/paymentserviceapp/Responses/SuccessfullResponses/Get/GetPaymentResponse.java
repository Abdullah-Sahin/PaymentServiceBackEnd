package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get;

import com.finalproject.paymentserviceapp.Layers.Entities.Payment;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Getter;

@Getter
public class GetPaymentResponse extends SuccessfullResponse {

    private final Payment payment;

    public GetPaymentResponse(Payment payment) {
        this.payment = payment;
        setMessage("Payment found successfully");
    }
}
