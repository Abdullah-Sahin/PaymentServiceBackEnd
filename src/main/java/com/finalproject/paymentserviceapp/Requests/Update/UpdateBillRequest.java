package com.finalproject.paymentserviceapp.Requests.Update;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
public class UpdateBillRequest {

    private Double amount;
    private LocalDate transactionDate;

    public UpdateBillRequest(Optional<Double> paramAmount, Optional<LocalDate> paramTransactionDate) {
        paramAmount.ifPresent(amount -> this.amount = amount);
        paramTransactionDate.ifPresent(date -> this.transactionDate = date);
    }
}
