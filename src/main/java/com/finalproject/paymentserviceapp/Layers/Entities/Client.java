package com.finalproject.paymentserviceapp.Layers.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String surname;
}
