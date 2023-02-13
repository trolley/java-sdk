[Payment Rails Java SDK](../README.md) > [BatchGateway](../classes/BatchGateway.md)

# Class: BatchGateway

Gateway class for batches
*__class__*: BatchGateway

## Index

### Methods

* [create](BatchGateway.md#create)
* [find](BatchGateway.md#find)
* [generateQuote](BatchGateway.md#generatequote)
* [paymentList](BatchGateway.md#paymentlist)
* [delete](BatchGateway.md#delete)
* [search](BatchGateway.md#search)
* [processBatch](BatchGateway.md#processBatch)
* [summary](BatchGateway.md#summary)
* [update](BatchGateway.md#update)

---

## Methods

<a id="create"></a>

### create

► **create**(batch: *`Batch`*): `Batch`

*Defined in [BatchGateway.java:95](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L95)*

Creates a batch with optional payments. This is the interface that is provide by the [Create Batch](https://docs.trolley.com/api/#create-a-batch) API

    Batch batch = client.batch.create("{\"sourceCurrency\": \"USD\", \"description\":\"Docs Create\"}");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batch | `Batch`   |  - |

**Returns:** `Batch`

---

<a id="find"></a>

### find

► **find**(batchId: *`string`*): `Batch`

*Defined in [BatchGateway.java:67](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L67)*

Retrieves a batch based on the batch id

    Batch batch = client.batch.find("B-12edc9j");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batchId | `string`   |  Payment Rails batch id (e.g. "B-xx999bb") |

**Returns:** `Batch`

---

<a id="generatequote"></a>

### generateQuote

► **generateQuote**(batchId: *`string`*): `Batch`

*Defined in [BatchGateway.java:182](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L182)*

Generate a FX quote for this batch

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batchId | `string`   |  Payment Rails payment id (e.g. "B-xx999bb") |

**Returns:** `Batch`

---

<a id="paymentlist"></a>

### paymentList

► **paymentList**(batchId: *`string`*, page?: *`number`*, pageSize?: *`number`*): `Payment`[]

*Defined in [BatchGateway.java:166](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L166)*

Return a paginated list of payments for this batch

**Parameters:**

| Param | Type | Default value | Description |
| ------ | ------ | ------ | ------ |
| batchId | `string`  | - |   Payment Rails payment id (e.g. "B-xx999bb") |
| page | `number`  | 1 |   starting a 1 |
| pageSize | `number`  | 10 |   in the range 0...1000 |

**Returns:** `Payment`[]

---

<a id="delete"></a>

### delete

► **delete**(batchId: *`string`*): `Boolean`

*Defined in [BatchGateway.java:132](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L132)*

Delete the given batch

    boolean response = client.batch.delete("B-1wdwdmi1");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batchId | `string`   |  Payment Rails batch (e.g. "B-xx999bb") |

**Returns:** `Boolean`

---

<a id="search"></a>

### search

► **search**(page?: *`number`*, pageSize?: *`number`*, term?: *`string`*): `Batch`[]

*Defined in [BatchGateway.java:146](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L146)*

Search for a batch matching the given term

**Parameters:**

| Param | Type | Default value | Description |
| ------ | ------ | ------ | ------ |
| page | `number`  | 1 |   - |
| pageSize | `number`  | 10 |   - |
| term | `string`  | &quot;&quot; |   string search term |

**Returns:** `Batch`[]

---

<a id="processBatch"></a>

### processBatch

► **processBatch**(batchId: *`string`*): `Batch`

*Defined in [BatchGateway.java:194](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L194)*

Start processing this batch

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batchId | `string`   |  Payment Rails batch id (e.g. "B-xx999bb") |

**Returns:** `Batch`

---

<a id="summary"></a>

### summary

► **summary**(batchId: *`string`*): `String`

*Defined in [BatchGateway.java:206](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/ca/paymentrails/paymentrails/BatchGateway.java#L206)*

Get a transaction totaled summary for this batch

    BatchSummary batchSummary = client.batch.summary("B-13dejc8ubc");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| batchId | `string`   |  Payment Rails payment id (e.g. "B-xx999bb") |

**Returns:** `String`

---