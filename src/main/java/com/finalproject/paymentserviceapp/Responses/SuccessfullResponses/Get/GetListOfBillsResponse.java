package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.SuccessfullResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetListOfBillsResponse extends SuccessfullResponse {

    private List<Bill> bills;

    public GetListOfBillsResponse(List<Bill> bills) {
        this.bills = bills;
        setMessage("Bills found");
    }
}
