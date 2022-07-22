package com.finalproject.paymentserviceapp.Responses.Exceptions;

import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.*;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.CustomException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.BillNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentForClientDoesNotExistException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class HandleException {


    @ExceptionHandler(value = {ClientNotFoundException.class,
            BillNotFoundException.class,
            BillNotFoundException.class,
            PaymentNotFoundException.class,
            PaymentForClientDoesNotExistException.class,
            IncompleteFieldsException.class,
            InvalidAmountException.class,
            InvalidDateException.class,
            NoFieldsCompletedException.class,
            PaymentForClientAlreadyExistsException.class,
            BillAlreadyPaidException.class}
    )
    public ResponseEntity<Object> handleException(CustomException e){
        ExceptionResponseBody body = new ExceptionResponseBody();
        body.setResponseCode(1);
        body.setMessage(e.getMessage());
        body.setDate(LocalDate.now());
        body.setStatus(e.getHttpStatus());
        return new ResponseEntity<>(body, body.getStatus());
    }
}
