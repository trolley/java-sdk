# PaymentRails_Batch

## About
The PaymentRails_Batch class contains static utily methods for interfacing with the batch API. For more information see the [API documentation](http://docs.paymentrails.com/#payments)

## **Methods**
---
### **get**
Utility method to make GET requests to the batch API

Parameters | Return Type
--- | ---:
(String batch_id) | Batch


---
### **post**
Utility method to make POST requests to the batch API

Parameters | Return Type
--- | ---:
(String body) | Batch

---
### **patch**
Utility method to make PATCH requests to the batch API

Parameters | Return Type
--- | ---:
(String batch_Id, String body) | String

---
### **delete**
Utility method to make DELETE requests to the batch API

Parameters | Return Type
--- | ---:
(String batch_id) | String

---
### **query**
Utility method for querying batches

Parameters | Return Type
--- | ---:
(no-parameters) | List<Batch>
(String term) | List<Batch>
(int page, int pageSize) | List<Batch>
(int page, int pageSize, String term) | List<Batch>

---
### **generateQuote**
Utility method to generating a quote for a bacth

Parameters | Return Type
--- | ---:
(String batch_id) | String


---
### **processBatch**
Utility method to send a batch out for processing

Parameters | Return Type
--- | ---:
(String batch_id) | String


---
### **summary**
Utility method to get a batch summary

Parameters | Return Type
--- | ---:
(String batch_id) | BatchSummary
