package com.finalproject.paymentserviceapp.Layers.Service;

import com.finalproject.paymentserviceapp.Layers.Dao.BillRepository;
import com.finalproject.paymentserviceapp.Layers.Dao.ClientRepository;
import com.finalproject.paymentserviceapp.Layers.Dao.PaymentRepository;
import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Layers.Entities.Payment;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentForClientDoesNotExistException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.PaymentNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Response;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get.GetListOfPaymentsResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get.GetPaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final ClientRepository clientRepository;
    private final BillRepository billRepository;
    private final PaymentRepository paymentRepository;

    public PaymentService(ClientRepository clientRepository, BillRepository billRepository, PaymentRepository paymentRepository) {
        this.clientRepository = clientRepository;
        this.billRepository = billRepository;
        this.paymentRepository = paymentRepository;
    }

    /**
     * finds the payments n the repository according to fields supplied
     * @param clientId the unique identifier of objects of class Client
     * @return response-entity containing responseCode, message, date and payments in the body
     * @throws ClientNotFoundException if no client exists with given id
     * @throws PaymentForClientDoesNotExistException if no payment exists for given client
     */
    public ResponseEntity<?> getPayments(Optional<Long> clientId) throws ClientNotFoundException, PaymentForClientDoesNotExistException {
        if(clientId.isPresent()){
            Client client = clientRepository.findById(clientId.get())
                    .orElseThrow(() -> new ClientNotFoundException(clientId.get()));
            Payment payment = paymentRepository.findPaymentByClient(client)
                    .orElseThrow(() -> new PaymentForClientDoesNotExistException(client));
            try{
                Response body = new GetPaymentResponse(payment);
                return new ResponseEntity<>(body, body.getStatus());
            }
            catch (Exception e){
                return ResponseEntity.internalServerError().build();
            }
        }
        try{
            List<Payment> paymentList = paymentRepository.findAll();
            Response body = new GetListOfPaymentsResponse(paymentList);
            return new ResponseEntity<>(body, body.getStatus());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * finds the payment in the repository for supplied id
     * @param paymentId the unique identifier of objects of class Payment
     * @return response-entity containing responseCode, message, date and payment in the body
     * @throws PaymentNotFoundException if no payment with given id exists
     */
    public ResponseEntity<?> getPaymentByPaymentId(Long paymentId) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException(paymentId));
        Response body = new GetPaymentResponse(payment);
        try{
            return new ResponseEntity<>(body, body.getStatus());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * finds the bill and payment, then updates required fields
     * @param bill the bill that will be paid
     * @param payment the payment that client of the bill has
     * @return true if process is successful, false otherwise
     */
    public boolean updatePayment(Bill bill, Payment payment){
        try{
            bill.setPaid(true);
            bill.setPaymentDate(LocalDate.now());
            payment.setTotalAmount(payment.getTotalAmount() + bill.getAmount());
            payment.setLastUpdate(LocalDate.now());
            billRepository.save(bill);
            paymentRepository.save(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
