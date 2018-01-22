# PaymentRails_Payment

## About
The PaymentRails_Payment class contains static utily methods for interfacing with the payment API. For more information see the [API documentation](http://docs.paymentrails.com/#payments)

## **Methods**
---
### **get**
Utility method to make GET requests to the payment API

Parameters | Return Type
--- | ---:
(String payment_id, String batch_id) | Payment


---
### **post**
Utility method to make POST requests to the payment API

Parameters | Return Type
--- | ---:
(String body) | Payment

---
### **patch**
Utility method to make PATCH requests to the payment API

Parameters | Return Type
--- | ---:
(String payment_id, String body,String batch_id) | String

---
### **delete**
Utility method to make DELETE requests to the payment API

Parameters | Return Type
--- | ---:
(String payment_id,String batch_id) | String

---
### **query**
Utility method for querying payments

Parameters | Return Type
--- | ---:
(String batch_id) | List<Payment>
(String batch_id,String term) | List<Payment>
(String batch_id,int page, int pageSize) | List<Payment>
(String batch_id,int page, int pageSize, String term) | List<Payment>