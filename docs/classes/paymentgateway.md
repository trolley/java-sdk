[Trolley Java SDK](../README.md) > [PaymentGateway](../classes/paymentgateway.md)

# Class: PaymentGateway

## Index

### Methods

- [create](paymentgateway.md#create)
- [find](paymentgateway.md#find)
- [remove](paymentgateway.md#remove)
- [search](paymentgateway.md#search)
- [update](paymentgateway.md#update)

---

## Methods

<a id="create"></a>

### create

► **create**(batchId: _`string`_, body: _`any`_): `Payment`

_Defined in [PaymentGateway.java:55](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/Gateway.java#L55)_

Create a new payment in a batch

    Payment payment = client.payment.create("B-1wed33", "{\"sourceAmount\":\"10.00\", \"recipient\": {\"id\": "R-123rd343"}}");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batchId | `string`   |  Trolley payment id (e.g. "B-xx999bb") |
| body | `any`   |  Payment information |

**Returns:** `Payment`

---

<a id="find"></a>

### find

► **find**(paymentId: _`string`_): `Payment`

_Defined in [PaymentGateway.java:34](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/Gateway.java#L34)_

Find a specific payment

    Payment payment = client.payment.find("P-12ed3e");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| paymentId | `string`   |  Trolley payment id (e.g. "P-aabccc") |

**Returns:** `Payment`

---

<a id="delete"></a>

### delete

► **delete**(paymentId: _`string`_, batchId: _`string`_): `boolean`

_Defined in [PaymentGateway.java:90](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/Gateway.java#L90)_

Delete a given payment -- Note you can only delete non processed payments

    Payment payment = client.payment.delete("P-12ed3e");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| paymentId | `string`   |  Trolley payment id (e.g. "P-aabccc") |
| batchId | `string`   |  Trolley payment id (e.g. "B-xx999bb") |

**Returns:** `boolean`

---

<a id="search"></a>

### search

► **search**(batchId: _`string`_, page?: _`number`_, pageSize?: _`number`_, term?: _`string`_): `Payment`[]

_Defined in [PaymentGateway.java:105](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/Gateway.java#L105)_

Search for payments in a given batch

**Parameters:**

| Param | Type | Default value | Description |
| ------ | ------ | ------ | ------ |
| batchId | `string`  | - |   Trolley payment id (e.g. "B-xx999bb") |
| page | `number`  | 1 |   Page number (1 based) |
| pageSize | `number`  | 10 |   Page size (0...1000) |
| term | `string`  | &quot;&quot; |   Any search terms to look for |

**Returns:** `Payment`[]

---

<a id="update"></a>

### update

► **update**(paymentId: _`string`_, batchId: _`string`_, body: _`any`_): `boolean`

_Defined in [PaymentGateway.java:74](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/Gateway.java#L74)_

Update a given payment

    boolean response = client.payment.update("B-1234fc", "{/"sourceAmount/": /"100.10/"}");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| paymentId | `string`   |  Trolley payment id (e.g. "P-aabccc") |
| batchId | `string`   |  Trolley payment id (e.g. "B-xx999bb") |
| body | `any`   |  Payment update information |

**Returns:** `boolean`

---
