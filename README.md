# Trolley Java SDK

A native Java SDK for Trolley

## Installation

#

#### For [Java](https://www.oracle.com/java/index.html)

#

#### To install the reference:

### Maven

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.trolley</groupId>
    <artifactId>java-sdk</artifactId>
    <version>1.1.3</version>
</dependency>
```

The library's source is hosted at [https://github.com/Trolley/java-sdk](https://github.com/trolley/java-sdk)

The library can be found at: [https://central.sonatype.com/artifact/com.trolley/java-sdk/](https://central.sonatype.com/artifact/com.trolley/java-sdk/)

## Getting Started

```java
import com.trolley.java-sdk.*;
import com.trolley.Exceptions.*;

public class TrolleyExample {
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

Methods should all have Java Doc comments to help you understand their usage. As mentioned the [full API documentation](http://docs.trolley.com)
is the best source of information about the API.

For more information please read the [Java API docs](https://github.com/PaymentRails/java-sdk/tree/master/docs) is available. The best starting point is:

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
