package com.finalproject.paymentserviceapp.Layers.Dao;

import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
