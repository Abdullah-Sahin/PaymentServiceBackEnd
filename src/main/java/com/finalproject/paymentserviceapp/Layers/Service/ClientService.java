package com.finalproject.paymentserviceapp.Layers.Service;

import com.finalproject.paymentserviceapp.Layers.Dao.ClientRepository;
import com.finalproject.paymentserviceapp.Layers.Dao.PaymentRepository;
import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import com.finalproject.paymentserviceapp.Layers.Entities.Payment;
import com.finalproject.paymentserviceapp.Requests.Create.CreateClientRequest;
import com.finalproject.paymentserviceapp.Requests.Update.UpdateClientRequest;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.IncompleteFieldsException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.NoFieldsCompletedException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.PaymentForClientAlreadyExistsException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import com.finalproject.paymentserviceapp.Responses.Response;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Create.CreateClientResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Create.CreatePaymentResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Delete.DeleteClientResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get.GetClientResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Get.GetListOfClientsResponse;
import com.finalproject.paymentserviceapp.Responses.SuccessfullResponses.Update.UpdateClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PaymentRepository paymentRepository;

    public ClientService(ClientRepository clientRepository, PaymentRepository paymentRepository) {
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
    }

    /**
     * finds all clients in the repository
     * @return response-entity containing responseCode, message, date and clients in the body
     */
    public ResponseEntity<?> getAllClients(){

        List<Client> clientList = clientRepository.findAll();
        Response response = new GetListOfClientsResponse(clientList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * finds client with given id in the repository
     * @param clientId the unique identifier of objects of Client class
     * @return response-entity containing responseCode, message, date and client in the body
     * @throws ClientNotFoundException if no client exists with given Id
     */
    public ResponseEntity<?> getClientById(Long clientId) throws ClientNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        Response response = new GetClientResponse(client);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * creates a new client object and adds it to repository
     * @param request an object containing name and surname fields
     * @return response-entity containing responseCode, message, date and client in the body
     * @throws IncompleteFieldsException if any of the fields is empty
     */
    public ResponseEntity<?> addClient(CreateClientRequest request) throws IncompleteFieldsException {
        Client client = new Client();
        if(request.getName() == null
                || request.getSurname() == null
                || request.getName().isEmpty()
                || request.getSurname().isEmpty()){
            throw new IncompleteFieldsException();
        }
        client.setName(request.getName());
        client.setSurname(request.getSurname());
        try{
            clientRepository.save(client);
            CreateClientResponse response = new CreateClientResponse(client);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * finds client in the repository and updates with given parameters
     * @param clientId the unique identifier of objects of class Client
     * @param request the request containing at least one of name and surname to update
     * @return response-entity containing responseCode, message, date and client in the body
     * @throws ClientNotFoundException if no client with id is present
     * @throws NoFieldsCompletedException if no fields supplied to update
     */
    public ResponseEntity<?> updateClient(Long clientId, UpdateClientRequest request) throws ClientNotFoundException, NoFieldsCompletedException {
        Client toUpdate = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        if( (request.getName() == null && request.getSurname() == null)
                || (request.getName() == null && request.getSurname().isEmpty())
                ||(request.getName().isEmpty() && request.getSurname() == null)
                ||(request.getName().isEmpty() && request.getSurname().isEmpty())){
            throw new NoFieldsCompletedException();
        }
        if(request.getName() != null && !request.getName().isEmpty()){
            toUpdate.setName(request.getName());
        }
        if(request.getSurname() != null && !request.getSurname().isEmpty()){
            toUpdate.setSurname(toUpdate.getSurname());
        }
        try{
            System.out.println(request.getName() + " surname: " + request.getSurname());
            clientRepository.save(toUpdate);
            Response response = new UpdateClientResponse(toUpdate);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * finds and deletes the client from repository
     * @param clientId the unique identifier of objects of class Client
     * @return response-entity containing responseCode, message, date and client in the body
     * @throws ClientNotFoundException if no client exists with given id
     */
    public ResponseEntity<?> deleteClientById(Long clientId) throws ClientNotFoundException {
        Client toDelete = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        clientRepository.delete(toDelete);
        Response response = new DeleteClientResponse(toDelete);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * creates a new payment for the client
     * @param clientId the unique identifier of objects of class Client
     * @return response-entity containing responseCode, message, date and payment in the body
     * @throws ClientNotFoundException if no client exists with given id
     * @throws PaymentForClientAlreadyExistsException if there is a payment for given client
     */
    public ResponseEntity<?> createPaymentForClient(Long clientId) throws ClientNotFoundException, PaymentForClientAlreadyExistsException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        Optional<Payment> paymentFound = paymentRepository.findPaymentByClient(client);
        if(paymentFound.isPresent()){
            throw new PaymentForClientAlreadyExistsException(clientId);
        }
        Payment payment = new Payment();
        payment.setClient(client);
        payment.setLastUpdate(LocalDate.now());
        payment.setTotalAmount(0);
        try{
            paymentRepository.save(payment);
            Response response = new CreatePaymentResponse(payment);
            return new ResponseEntity<>(response, response.getStatus());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
