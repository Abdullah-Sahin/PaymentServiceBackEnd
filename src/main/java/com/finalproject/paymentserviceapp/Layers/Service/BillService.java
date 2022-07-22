package com.finalproject.paymentserviceapp.Layers.Service;

import com.finalproject.paymentserviceapp.Layers.Dao.BillRepository;
import com.finalproject.paymentserviceapp.Layers.Dao.ClientRepository;
import com.finalproject.paymentserviceapp.Layers.Dao.PaymentRepository;
import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Layers.Entities.Payment;
import com.finalproject.paymentserviceapp.Requests.Create.CreateBillRequest;
import com.finalproject.paymentserviceapp.Requests.Update.UpdateBillRequest;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.*;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.BillNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentForClientDoesNotExistException;
import com.finalproject.paymentserviceapp.Responses.Response;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.BillPaidResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Create.CreateBillResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Delete.DeleteBillResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get.GetBillResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get.GetListOfBillsResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Update.UpdateBillResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;
    private final ClientRepository clientRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;

    @Autowired
    public BillService(BillRepository billRepository, ClientRepository clientRepository, PaymentRepository paymentRepository, PaymentService paymentService) {
        this.billRepository = billRepository;
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }

    /**
     * finds and return bills in the repository with given constraints
     * @param clientId the unique identifier of objects of class Client
     * @param isPaid the boolean value that shows if a bill is paid
     * @return response-entity containing responseCode, message, date and bills in the body
     * @throws ClientNotFoundException if no client with supplied id exists
     */
    public ResponseEntity<?> getBills(Optional<Long> clientId, Optional<Boolean> isPaid) throws ClientNotFoundException {
        List<Bill> bills;
        if(clientId.isPresent() && isPaid.isPresent()){
            Client client = clientRepository.findById(clientId.get())
                    .orElseThrow(() -> new ClientNotFoundException(clientId.get()));
            bills = billRepository.findBillsByClientAndPaid(client, isPaid.get());
            GetListOfBillsResponse response = new GetListOfBillsResponse(bills);
            return new ResponseEntity<>(response, response.getStatus());
        }
        if(clientId.isPresent()){
            Client client = clientRepository.findById(clientId.get())
                    .orElseThrow(() -> new ClientNotFoundException(clientId.get()));
            bills = billRepository.findBillsByClient(client);
            GetListOfBillsResponse response = new GetListOfBillsResponse(bills);
            return new ResponseEntity<>(response, response.getStatus());
        }
        if(isPaid.isPresent()){
            bills = billRepository.findBillsByPaid(isPaid.get());
            GetListOfBillsResponse response = new GetListOfBillsResponse(bills);
            return new ResponseEntity<>(response, response.getStatus());
        }
        bills = billRepository.findAll();
        GetListOfBillsResponse response = new GetListOfBillsResponse(bills);
        return new ResponseEntity<>(response, response.getStatus());
    }

    /**
     * find the bill in the repository with given id
     * @param billId the unique identifier of objects of class Bill
     * @return response-entity containing responseCode, message, date and bill in the body
     * @throws BillNotFoundException no bill exists with given id
     */
    public ResponseEntity<?> getBillByBillId(Long billId) throws BillNotFoundException {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException(billId));
        Response response = new GetBillResponse(bill);
        return new ResponseEntity<>(response, response.getStatus());
    }

    /**
     * creates a new bill and add it to repository
     * @param request an object that contains clientId and amount of the bill
     * @return response-entity containing responseCode, message, date and bill in the body
     * @throws ClientNotFoundException if no clients with given id exists
     * @throws IncompleteFieldsException if any of the fields is empty
     * @throws InvalidAmountException if amount supplied is negative
     */
    public ResponseEntity<?> addBill(CreateBillRequest request) throws ClientNotFoundException, IncompleteFieldsException, InvalidAmountException {
        if(request.getClientId() == null || request.getAmount() == null){
            throw new IncompleteFieldsException();
        }
        if(request.getAmount() < 0){
            throw new InvalidAmountException();
        }
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new ClientNotFoundException(request.getClientId()));
        Bill bill = new Bill();
        bill.setClient(client);
        bill.setAmount(request.getAmount());
        bill.setTransactionDate(LocalDate.now());
        bill.setPaid(false);
        bill.setPaymentDate(null);
        try{
            billRepository.save(bill);
            Response body = new CreateBillResponse(bill);
            return new ResponseEntity<>(body, body.getStatus());
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * finds and updates the supplied fields of bill in the repository
     * @param billId the unique identifier of objects of class Bill
     * @param request the request containing amount and date
     * @return response-entity containing responseCode, message, date and bill in the body
     * @throws BillNotFoundException if no bill exists with given id
     * @throws NoFieldsCompletedException if no fields supplied to update
     * @throws InvalidAmountException if amount is negative
     * @throws BillAlreadyPaidException if bill is already paid
     * @throws InvalidDateException if date supplied is in the future
     */
    public ResponseEntity<?> updateBillById(Long billId, UpdateBillRequest request) throws BillNotFoundException, NoFieldsCompletedException, InvalidAmountException, BillAlreadyPaidException, InvalidDateException {
        Bill toUpdate = billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException(billId));
        if(toUpdate.isPaid()){
            throw new BillAlreadyPaidException();
        }
        if(request.getAmount() == null && request.getTransactionDate() == null){
            throw new NoFieldsCompletedException();
        }
        if(request.getAmount() != null && request.getAmount() < 0){
            throw new InvalidAmountException();
        }
        if(request.getTransactionDate() != null && request.getTransactionDate().isAfter(LocalDate.now())){
            throw new InvalidDateException();
        }
        if(request.getAmount() != null){
            toUpdate.setAmount(request.getAmount());
        }
        if(request.getTransactionDate() != null){
            toUpdate.setTransactionDate(request.getTransactionDate());
        }
        try{
            billRepository.save(toUpdate);
            Response body = new UpdateBillResponse(toUpdate);
            return new ResponseEntity<>(body, body.getStatus());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    /**
     * finds and removes the bill from repository
     * @param billId the unique identifier of objects of class Bill
     * @return response-entity containing responseCode, message, date and bill in the body
     * @throws BillNotFoundException if no bill with given id exists
     * @throws BillAlreadyPaidException if bill was paid
     */
    public ResponseEntity<?> deleteBillById(Long billId) throws BillNotFoundException, BillAlreadyPaidException {
        Bill toDelete = billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException(billId));
        if(toDelete.isPaid()){
            throw new BillAlreadyPaidException();
        }
        try{
            billRepository.delete(toDelete);
            Response body = new DeleteBillResponse(toDelete);
            return new ResponseEntity<>(body, body.getStatus());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * finds the bill and updates required fields
     * @param billId the unique identifier of objects of class Bill
     * @return response-entity containing responseCode, message, date and bill in the body
     * @throws BillNotFoundException if no bill with given id exists
     * @throws PaymentForClientDoesNotExistException if no payment exists for the client
     * @throws BillAlreadyPaidException if bill already was paid
     */
    public ResponseEntity<?> payBillByBillId(Long billId) throws BillNotFoundException, PaymentForClientDoesNotExistException, BillAlreadyPaidException {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException(billId));
        if(bill.isPaid()){
            throw new BillAlreadyPaidException();
        }
        Client client = bill.getClient();
        Payment payment = paymentRepository.findPaymentByClient(client)
                .orElseThrow(() -> new PaymentForClientDoesNotExistException(client));
        if(paymentService.updatePayment(bill, payment)){
            Response body = new BillPaidResponse(bill);
            return new ResponseEntity<>(body, body.getStatus());
        }
        return ResponseEntity.internalServerError().build();
    }
}
