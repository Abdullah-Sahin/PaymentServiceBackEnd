package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Create;

import com.finalproject.paymentserviceapp.Layers.Entities.Payment;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

@Data
public class CreatePaymentResponse extends SuccessfullResponse {
    private Payment payment;

    public CreatePaymentResponse(Payment payment) {
        this.payment = payment;
        setMessage("Payment has been created successfully");
    }
}
