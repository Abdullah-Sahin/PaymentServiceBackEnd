# Payment Service App


## EndPoints

### Client

---      
https://localhost8080/PaymentServiceApp/clients

Get request returns all clients
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetAllClients.png)

Post request creates a client (name and surname are both required)
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PostClient.png)

---
https://localhost8080/PaymentServiceApp/clients/{clientId}

Get request returns client with given clientId
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetClientById.png)

Put request with name and surname, at least one field required
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/UpdateClient.png)

Delete request with empty body
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/DeleteClient.png)

---
https://localhost8080/PaymentServiceApp/clients/{clientId}createPayment

Post request creates a payment for given client
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PostPaymentForClient.png)

---

### Bill

---
https://localhost8080/PaymentServiceApp/bills

Get request returns all bills
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetAllBills.png)

Post request creates a new bill with amount and clientId, both fields required
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PostBill.png)

---
https://localhost8080/PaymentServiceApp/bills/{billId}

Get request returns bill with given billId
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillById.png)

Put request with amount and transaction date, at least one field required
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/UpdateBill.png)

Delete Request
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/DeleteBill.png)

---
https://localhost8080/PaymentServiceApp/bills?clientId={clientId}

Get request returns bills of the client supplied
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillsByClient.png)

---
https://localhost8080/PaymentServiceApp/bills?isPaid={paymentStatus}[Sample Photo]()

Get request returns bills with supplied payment status
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillsByPaid.png)

---
https://localhost8080/PaymentServiceApp/bills?clientId={clientId}&isPaid={paymentStatus}

Get request returns the bills belonging to given client and are of given payment status
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillsByClient%26Paid.png)

---
https://localhost8080/PaymentServiceApp/pay/{billId}/pay

Put request with empty body to pay with given billId
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PayBill.png)

---

### Payment

---
https://localhost8080/PaymentServiceApp/payments

Get request returns all payments
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetAllPayments.png)

---
https://localhost8080/PaymentServiceApp/payment?clientId={clientId}

Get request return the payment of client given
[Sample Photo](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetPaymentById.png)

## Sample Photos

---

1. Get All Clients
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetAllClients.png)
2. Get Client By clientId
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetClientById.png)
3. Get All Bills
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetAllBills.png)
4. Get Bills By Client
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillsByClient.png)
5. Get Bills By Payment Status
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillsByPaid.png)
6. Get Bills By Client & Payment Status
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillsByClient%26Paid.png)
7. Get Bill By billId
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetBillById.png)
8. Get All Payments
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetAllPayments.png)
9. Get Payment By ClientId
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/GetPaymentById.png)

## Post Requests

---

1. Post Client Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PostClient.png)
2. Post Bill Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PostBill.png)
3. Post Payment For Client Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PostPaymentForClient.png)

## Update Requests

---
1. Update Client Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/UpdateClient.png)
2. Update Bill Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/UpdateBill.png)
3. Pay Bill Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/PayBill.png)

## Delete Requests

---
1. Delete Client Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/DeleteClient.png)
2. Delete Bill Request
   ![](https://github.com/Abdullah-Sahin/PaymentServiceBackEnd/blob/main/Photos/DeleteBill.png)






