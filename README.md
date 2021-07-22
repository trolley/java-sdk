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
    <version>1.0.1</version>
</dependency>
```

The library is hosted at [insert github link]

## Getting Started

```java
import ca.paymentrails.paymentrails.*;
import ca.paymentrails.Exceptions.*;

public class PaymentRailsExample {
    public static void main(String[] args) {

       Gateway client = new Gateway(new Configuration("YOUR_PUBLIC_KEY","YOUR_PRIVATE_KEY","production"));

        try {
            Recipient recipient = client.recipient.find("R-1a2B3c4D5e6F7g8H9i0J1k");
            System.out.println(recipient.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Usage

Methods should all have Java Doc comments to help you understand their usage. As mentioned the [full API documentation](http://docs.paymentrails.com)
is the best source of information about the API.

For more information please read the [Java API docs](https://github.com/PaymentRails/paymentrails_dotnet/tree/master/docs/) is available. The best starting point is:

| Data Type         | SDK Documentation                                                                                                              |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| Batch             | [API Docs for Batch](https://github.com/PaymentRails/java-sdk/tree/master/docs/classes/batchgateway.md)                        |
| Payment           | [API Docs for Payment](https://github.com/PaymentRails/java-sdk/tree/master/docs/classes/paymentgateway.md)                    |
| Recipient         | [API Docs for Recipient](https://github.com/PaymentRails/java-sdk/tree/master/docs/classes/recipientgateway.md)                |
| Recipient Account | [API Docs for Recipient Account](https://github.com/PaymentRails/java-sdk/tree/master/docs/classes/recipientaccountgateway.md) |

### merchantKey

- **Type**: Authorization
- **Authorization parts**: Access code, Secret code
- **Location**: HTTP header
