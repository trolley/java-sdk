[Trolley Java SDK](../README.md) > [RecipientGateway](../classes/RecipientGateway.md)

# Class: RecipientGateway

## Index

### Methods

* [create](RecipientGateway.md#create)
* [find](RecipientGateway.md#find)
* [remove](RecipientGateway.md#remove)
* [search](RecipientGateway.md#search)
* [update](RecipientGateway.md#update)

---

## Methods

<a id="create"></a>

### create

► **create**(body: *[Recipient](../types/recipient.md)*): `Recipient`

*Defined in [RecipientGateway.java:82](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/RecipientGateway.java#L82)*

Create a given recipient

    String body = "{\"type\": \"individual\",\"firstName\": \"Tom\",\"lastName\": \"Jones\",\"email\": \"tomjones"@example.com\"}";

    Recipient recipient = client.recipient.create(body);

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| body | [Recipient](../types/recipient.md)   |  The recipient information to create |

**Returns:** `Recipient`

---

<a id="find"></a>

### find

► **find**(recipientId: *`string`*): `Recipient`

*Defined in [RecipientGateway.java:58](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/RecipientGateway.java#L58)*

Find a specific recipient by their Trolley recipient ID

Recipient recipient = client.recipient.find(R-efr313md8cj);

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |

**Returns:** `Recipient`

---

<a id="delete"></a>

### delete

► **delete**(recipientId: *`string`*): `boolean`

*Defined in [RecipientGateway.java:115](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/RecipientGateway.java#L115)*

Delete the given recipient.

    boolean response = client.recipient.delete("R-12a3c2ex31");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |

**Returns:** `boolean`

---

<a id="search"></a>

### search

► **search**(page: *`number`*, pageSize: *`number`*, term: *`string`*): `Recipient`[]

*Defined in [RecipientGateway.java:123](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/RecipientGateway.java#L123)*

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| page | `number`   |  - |
| pageSize | `number`   |  - |
| term | `string`   |  - |

**Returns:** `Recipient`[]

---

<a id="update"></a>

### update

► **update**(body: *[Recipient](../types/recipient.md)*): `boolean`

*Defined in [RecipientGateway.java:100](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/RecipientGateway.java#L100)*

Update the given recipient

    boolean response = client.ecipient.update("R-12xe3","{\"firstName\": \"Mark\"}");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| body | [Recipient](../types/recipient.md)   |  the changes to make to the recipient |

**Returns:** `boolean`

---