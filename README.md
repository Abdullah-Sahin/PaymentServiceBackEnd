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








