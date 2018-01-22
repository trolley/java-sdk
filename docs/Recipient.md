# PaymentRails_Recipient

## About
The PaymentRails_Recipient class contains static utily methods for interfacing with the recipient API. For more information see the [API documentation](http://docs.paymentrails.com/#recipients)

## **Methods**
---
### **get**
Utility method to make GET requests to the recipient API

Parameters | Return Type
---| ---:
(String recipient_id) | Recipient

---
### **findLogs**
Utility method to make a GET request to the recipient API for the recipient logs

Parameters | Return Type
---| ---:
(String recipient_id) | String

---
### **findPayments**
Utility method to make a GET request to the recipient API for the recipient payments

Parameters | Return Type
---| ---:
(String recipient_id) | List<Payment>

---
### **post**
Utility method to make POST requests to the recipient API

Parameters | Return Type
--- | ---:
(String body) | Recipient

---
### **patch**
Utility method to make PATCH requests to the recipient API

Parameters | Return Type
--- | ---:
(String recipient__id, $body) | String

---
### **delete**
Utility method to make DELETE requests to the recipient API

Parameters | Return Type
--- | ---:
(String recipient_id) | String

---
### **query**
Utility method for querying recipients

Parameters | Return Type
--- | ---:
(no-parameters) | List<Recipient>
(String term) | List<Recipient>
(int page, int pageSize) | List<Recipient>
(int page, int pageSize, String term) | List<Recipient>