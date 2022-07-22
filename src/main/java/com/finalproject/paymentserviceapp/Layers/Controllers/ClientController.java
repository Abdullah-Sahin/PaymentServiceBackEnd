package com.finalproject.paymentserviceapp.Layers.Controllers;

import com.finalproject.paymentserviceapp.Layers.Service.ClientService;
import com.finalproject.paymentserviceapp.Requests.Create.CreateClientRequest;
import com.finalproject.paymentserviceapp.Requests.Update.UpdateClientRequest;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.IncompleteFieldsException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.NoFieldsCompletedException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.PaymentForClientAlreadyExistsException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.NotFound.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/PaymentServiceApp/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping(path = "/{clientId}")
    public ResponseEntity<?> getClientByClientId(@PathVariable Long clientId) throws ClientNotFoundException {
        return clientService.getClientById(clientId);
    }

    @PostMapping
    public ResponseEntity<?> addClient(@RequestBody CreateClientRequest request) throws IncompleteFieldsException {
        return clientService.addClient(request);
    }

    @PutMapping(path = "/{clientId}")
    public ResponseEntity<?> updateClient(@PathVariable Long clientId, @RequestBody UpdateClientRequest request) throws ClientNotFoundException, NoFieldsCompletedException {
        return clientService.updateClient(clientId, request);
    }

    @DeleteMapping(path = "/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) throws ClientNotFoundException {
        return clientService.deleteClientById(clientId);
    }
    @PostMapping(path = "/{clientId}/createPayment")
    public ResponseEntity<?> createPaymentForClient(@PathVariable Long clientId) throws ClientNotFoundException, PaymentForClientAlreadyExistsException {
        return clientService.createPaymentForClient(clientId);
    }
}
