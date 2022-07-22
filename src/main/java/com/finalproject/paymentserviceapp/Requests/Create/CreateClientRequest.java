package com.finalproject.paymentserviceapp.Requests.Create;

import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.IncompleteFieldsException;
import com.finalproject.paymentserviceapp.Responses.Exceptions.CustomExceptions.BadRequest.NoFieldsCompletedException;
import lombok.Data;

import java.util.Optional;

@Data
public class CreateClientRequest {
    private String name;
    private String surname;

    public CreateClientRequest(Optional<String> paramName, Optional<String> paramSurname) throws IncompleteFieldsException {
        paramName.ifPresent(s -> this.name = s.replaceAll("\\d", "").replaceAll("\\W+", ""));
        paramSurname.ifPresent(s -> this.surname = s.replaceAll("\\d", "").replaceAll("\\W+", ""));

    }
}
