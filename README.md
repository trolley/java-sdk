# Payment Rails JAVA SDK

A native JAVA SDK for the Payment Rails API


## Installation

#

#### For [Java](https://www.oracle.com/java/index.html)

#
#### To install the reference:

### Maven

Add this dependency to your project's POM:
```xml
<dependency>
    <groupId>ca.paymentrails</groupId>
    <artifactId>paymentrails</artifactId>
    <version>1.0</version>
</dependency>
```

The library is hosted at [insert github link]

## Getting Started

```java
import ca.paymentrails.paymentrails.*;
import ca.paymentrails.Exceptions.*;

public class PaymentRailsExample {
    public static void main(String[] args) {
        
        PaymentRails_Configuration.setApiKey("<YOUR-API-KEY>");

        String recipient_id = "R-91XQ4GK3FNHG0";
        try {
            String response = PaymentRails_Recipient.get(recipient_id);
            System.out.println(response);
        } catch (InvalidConnectionException | InvalidFieldException | InvalidStatusCodeException e) {
            e.printStackTrace();
        }
    }
}
```



## Documentation for API Endpoint Methods

All URIs are relative to *https://api.paymentrails.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*Recipient | [**get**](docs/Recipient.md#get) | **GET** /recipient/ |
*Recipient | [**post**](docs/Recipient.md#post) | **POST** /recipient/ |
*Recipient | [**patch**](docs/Recipient.md#patch) | **PATCH** /recipient/ |
*Recipient | [**delete**](docs/Recipient.md#delete) | **DELETE** /recipient/ |
*Recipient | [**query**](docs/Recipient.md#query) | **GET** /recipient/ |
*PayoutMethods | [**get**](docs/PayoutMethods.md#get) | **GET** /recipient/<recipient_id>/payout-methods |
*PayoutMethods | [**post**](docs/PayoutMethods.md#post) | **POST** /recipient/<recipient_id>/payout-methods |
*PayoutMethods | [**patch**](docs/PayoutMethods.md#patch) | **PATCH** /recipient/<recipient_id>/payout-methods |
*PayoutMethods | [**delete**](docs/PayoutMethods.md#delete) | **DELETE** /recipient/<recipient_id>/payout-methods |
*Batch | [**get**](docs/Batch.md#get) | **GET** /batch/ |
*Batch | [**post**](docs/Batch.md#post) | **POST** /batch/ |
*Batch | [**patch**](docs/Batch.md#patch) | **PATCH** /batch/ |
*Batch | [**delete**](docs/Batch.md#delete) | **DELETE** /batch/ |
*Batch | [**query**](docs/Batch.md#query) | **GET** /batch/ |
*Payment | [**get**](docs/Payment.md#get) | **GET** /payments/ |
*Payment | [**post**](docs/Payment.md#post) | **POST** /batch/<batch_id>/payments |
*Payment | [**patch**](docs/Payment.md#patch) | **PATCH** /batch/<batch_id>/payments |
*Payment | [**delete**](docs/Payment.md#delete) | **DELETE** /batch/<batch_id>/payments |
*Payment | [**query**](docs/Payment.md#query) | **GET** /payments/ |
*Balances | [**get**](docs/Balances.md#get) | **GET** /balances/ |

 
 ## Documentation for Authorization


### merchantKey

- **Type**: API key
- **API key parameter name**: x-api-key
- **Location**: HTTP header