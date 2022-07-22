package com.finalproject.paymentserviceapp.Layers.Dao;

import com.finalproject.paymentserviceapp.Layers.Entities.Bill;
import com.finalproject.paymentserviceapp.Layers.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("select b from Bill b order by b.client.clientId asc")
    List<Bill> findAll();
    @Query("select b from Bill b where b.client = ?1 order by b.billId")
    List<Bill> findBillsByClient(Client client);
    @Query(value = "select b from Bill b where b.isPaid = ?1")
    List<Bill> findBillsByPaid(Boolean isPaid);
    @Query(value = "select b from Bill b where b.client = ?1 and b.isPaid = ?2")
    List<Bill> findBillsByClientAndPaid(Client client, Boolean isPaid);
}
