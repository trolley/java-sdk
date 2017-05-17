# PaymentRails_Payment

## About
The PaymentRails_Payment class contains static utily methods for interfacing with the payment API. For more information see the [API documentation](http://docs.paymentrails.com/#payments)

## **Methods**
---
### **get**
Utility method to make GET requests to the payment API

Parameters | Return Type
--- | ---:
(String payment_id,String batch_id) | String


---
### **post**
Utility method to make POST requests to the payment API

Parameters | Return Type
--- | ---:
(String body) | String

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
(String batch_id) | String
(String batch_id,String term) | String
(String batch_id,int page, int pageSize) | String
(String batch_id,int page, int pageSize, String term) | String