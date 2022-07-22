package com.finalproject.paymentserviceapp.Layers.Controllers;

import com.finalproject.paymentserviceapp.Layers.Service.BillService;
import com.finalproject.paymentserviceapp.Requests.Create.CreateBillRequest;
import com.finalproject.paymentserviceapp.Requests.Update.UpdateBillRequest;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.*;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.BillNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentForClientDoesNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/PaymentServiceApp/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public ResponseEntity<?> getBills(@RequestParam Optional<Long> clientId, @RequestParam Optional<Boolean> isPaid) throws ClientNotFoundException {
        return billService.getBills(clientId, isPaid);
    }

    @GetMapping(path = "/{billId}")
    public ResponseEntity<?> getBillByBillId(@PathVariable Long billId) throws BillNotFoundException {
        return billService.getBillByBillId(billId);
    }

    @PostMapping
    public ResponseEntity<?> addBill(@RequestBody CreateBillRequest request) throws ClientNotFoundException, IncompleteFieldsException, InvalidAmountException {
        return billService.addBill(request);
    }

    @PutMapping(path = "/{billId}")
    public ResponseEntity<?> updateBillById(@PathVariable Long billId, @RequestBody UpdateBillRequest request) throws BillAlreadyPaidException, InvalidAmountException, NoFieldsCompletedException, BillNotFoundException, InvalidDateException {
        return billService.updateBillById(billId, request);
    }

    @DeleteMapping(path = "/{billId}")
    public ResponseEntity<?> deleteBillById(@PathVariable Long billId) throws BillNotFoundException, BillAlreadyPaidException {
        return billService.deleteBillById(billId);
    }

    @PutMapping(path = "/{billId}/pay")
    public ResponseEntity<?> payBillByBillId(@PathVariable Long billId) throws PaymentForClientDoesNotExistException, BillNotFoundException, BillAlreadyPaidException {
        return billService.payBillByBillId(billId);
    }
}
