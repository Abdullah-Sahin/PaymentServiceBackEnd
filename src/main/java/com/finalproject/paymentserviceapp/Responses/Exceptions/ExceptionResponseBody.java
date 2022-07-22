package com.finalproject.paymentserviceapp.Responses.Exceptions;

import com.finalproject.paymentserviceapp.Responses.Response;
import lombok.Data;

@Data
public class ExceptionResponseBody extends Response {

    public ExceptionResponseBody(){
        setResponseCode(1);
    }
}
