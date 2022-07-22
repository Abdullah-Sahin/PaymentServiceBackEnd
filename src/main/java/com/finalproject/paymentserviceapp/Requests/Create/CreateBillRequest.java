package com.finalproject.paymentserviceapp.Requests.Create;

import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.IncompleteFieldsException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.InvalidAmountException;
import lombok.Data;

import java.util.Optional;

@Data
public class CreateBillRequest {

    private Long clientId;
    private Double amount;

    public CreateBillRequest(Optional<Long> paramClientId, Optional<Double> paramAmount) throws IncompleteFieldsException, InvalidAmountException {
        paramClientId.ifPresent(clientId -> this.clientId = clientId);
        paramAmount.ifPresent(amount -> this.amount = amount);
    }
}
