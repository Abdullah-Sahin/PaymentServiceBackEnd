package com.finalproject.paymentserviceapp.Requests.Update;

import lombok.Data;

import java.util.Optional;

@Data
public class UpdateClientRequest {

    private String name;
    private String surname;

    public UpdateClientRequest(Optional<String> paramName, Optional<String> paramSurname){
        paramName.ifPresent(s -> this.name = s);
        paramSurname.ifPresent(s -> this.surname = s);
    }
}

