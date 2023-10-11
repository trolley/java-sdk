# Trolley Java SDK

Native [Java](https://www.oracle.com/java/index.html) SDK for Trolley

## Installation

#### Maven

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.trolley</groupId>
    <artifactId>java-sdk</artifactId>
    <version>2.0.0</version>
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
        Configuration config = new Configuration("<YOUR_ACCESS_KEY>","<YOUR_SECRET_KEY>");
        
        // Provide your custom HttpClient
        // Configuration config = new Configuration("<YOUR_ACCESS_KEY>","<YOUR_SECRET_KEY>", customHttpClient);

        Gateway client = new Gateway(config);

        try {
            Recipient recipient = client.recipient.find("R-1a2B3c4D5e6F7g8H9i0J1k");
            System.out.println(recipient.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```



## Providing custom API base url

If you are running from source and want to provide custom base url for the SDK to use (e.g. using a mock server temporarily), you will have to do the following:

1. Create a file named `.env` in the SDK source's root
2. Add a parameter in the env file:
```java
BASE_URL=https://localhost:3000
```
3. While creating the `Configuration` object, pass a third parameter `"development"`  so the constructor can look for the `BASE_URL` in the `.env` file:

```java
Configuration config = new Configuration("ACCESS_KEY","SECRET_KEY", "development")
Gateway client = new Gateway(config);
```

A sample `.env` file is provided in the project rood named `.env.example`.


## Documentation

Methods should all have Java Doc comments to help you understand their usage.

For more code samples, refer to our documentation on [https://docs.trolley.com](https://docs.trolley.com)

Limited [Javadocs](https://github.com/PaymentRails/java-sdk/tree/master/docs) are available too.
