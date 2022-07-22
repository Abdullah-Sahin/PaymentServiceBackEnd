package com.finalproject.paymentserviceapp.Layers.Controllers;

import com.finalproject.paymentserviceapp.Layers.Service.PaymentService;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentForClientDoesNotExistException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/PaymentServiceApp/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<?> getPayments(@RequestParam Optional<Long> clientId) throws ClientNotFoundException, PaymentForClientDoesNotExistException {
        return paymentService.getPayments(clientId);
    }
    @GetMapping(path = "/{paymentId}")
    public ResponseEntity<?> getPaymentByPaymentId(@PathVariable Long paymentId) throws PaymentNotFoundException {
        return paymentService.getPaymentByPaymentId(paymentId);
    }
}
