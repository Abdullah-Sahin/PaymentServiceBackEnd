package com.finalproject.paymentserviceapp.Responses.SuccessfullResponses;

import com.finalproject.paymentserviceapp.Responses.Response;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class SuccessfullResponse extends Response {

    public SuccessfullResponse(){
        setResponseCode(0);
        setDate(LocalDate.now());
        setStatus(HttpStatus.OK);
    }
}
