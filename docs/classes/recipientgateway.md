[Payment Rails Java SDK](../README.md) > [RecipientGateway](../classes/RecipientGateway.md)

# Class: RecipientGateway

## Index

### Methods

- [create](RecipientGateway.md#create)
- [find](RecipientGateway.md#find)
- [remove](RecipientGateway.md#remove)
- [search](RecipientGateway.md#search)
- [update](RecipientGateway.md#update)

---

## Methods

<a id="create"></a>

### create

► **create**(body: _[Recipient](../types/recipient.md)_): `Recipient`

_Defined in [RecipientGateway.java:82](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientGateway.java#L82)_

Create a given recipient

    String body = "{\"type\": \"individual\",\"firstName\": \"Tom\",\"lastName\": \"Jones\",\"email\": \"tomjones"@example.com\"}";

    Recipient recipient = client.recipient.create(body);

**Parameters:**

| Param | Type                               | Description                         |
| ----- | ---------------------------------- | ----------------------------------- |
| body  | [Recipient](../types/recipient.md) | The recipient information to create |

**Returns:** `Recipient`

---

<a id="find"></a>

### find

► **find**(recipientId: _`string`_): `Recipient`

_Defined in [RecipientGateway.java:58](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientGateway.java#L58)_

Find a specific recipient by their Payment Rails recipient ID

Recipient recipient = client.recipient.find(R-efr313md8cj);

**Parameters:**

| Param       | Type     | Description                                   |
| ----------- | -------- | --------------------------------------------- |
| recipientId | `string` | The Payment Rails recipient ID (e.g. R-xyzzy) |

**Returns:** `Recipient`

---

<a id="delete"></a>

### delete

► **delete**(recipientId: _`string`_): `boolean`

_Defined in [RecipientGateway.java:115](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientGateway.java#L115)_

Delete the given recipient.

    boolean response = client.recipient.delete("R-12a3c2ex31");

**Parameters:**

| Param       | Type     | Description                                   |
| ----------- | -------- | --------------------------------------------- |
| recipientId | `string` | The Payment Rails recipient ID (e.g. R-xyzzy) |

**Returns:** `boolean`

---

<a id="search"></a>

### search

► **search**(page: _`number`_, pageSize: _`number`_, term: _`string`_): `Recipient`[]

_Defined in [RecipientGateway.java:123](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientGateway.java#L123)_

**Parameters:**

| Param    | Type     | Description |
| -------- | -------- | ----------- |
| page     | `number` | -           |
| pageSize | `number` | -           |
| term     | `string` | -           |

**Returns:** `Recipient`[]

---

<a id="update"></a>

### update

► **update**(body: _[Recipient](../types/recipient.md)_): `boolean`

_Defined in [RecipientGateway.java:100](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientGateway.java#L100)_

Update the given recipient

    boolean response = client.ecipient.update("R-12xe3","{\"firstName\": \"Mark\"}");

**Parameters:**

| Param | Type                               | Description                          |
| ----- | ---------------------------------- | ------------------------------------ |
| body  | [Recipient](../types/recipient.md) | the changes to make to the recipient |

**Returns:** `boolean`

---
