[Trolley Java SDK](../README.md) > [RecipientAccountGateway](../classes/recipientaccountgateway.md)

# Class: RecipientAccountGateway

## Index

### Methods

- [findAll](recipientaccountgateway.md#findAll)
- [create](recipientaccountgateway.md#create)
- [find](recipientaccountgateway.md#find)
- [remove](recipientaccountgateway.md#remove)
- [update](recipientaccountgateway.md#update)

---

## Methods

<a id="all"></a>

### all

► **all**(recipientId: _`string`_): `List<RecipientAccount>`(recipientaccount.md)[]>

_Defined in [RecipientAccountGateway.java:33](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientAccountGateway.java#L33)_

Fetch all of the accounts for a given Trolley recipient

    $response = PaymentRails\RecipientAccount::all($recipient_id);
    List<RecipientAccount> recipientAccounts = client.recipientAccount.findAll("R-123r4cs");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |

**Returns:** `List<RecipientAccount>(recipientaccount.md)[]>

---

<a id="create"></a>

### create

► **create**(recipientId: _`string`_, body: _`RecipientAccount`_): `RecipientAccount`(recipientaccount.md)>

_Defined in [RecipientAccountGateway.java:79](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientAccountGateway.java#L79)_

Create a new recipient account

    RecipientAccount recipientAccount = client.recipientAccount.create("R-112e2c3x","{\"type\":\"bank-transfer\",\"primary\":\"true\",\"country\":\"CA\",\"currency\":\"CAD\",\"accountNum\":\"012345678\",\"bankId\":\"004\",\"branchId\":\"47261\",\"accountHolderName\":\"John Smith\"}");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |
| body | `string`   |  Account information |

**Returns:** `RecipientAccount`(recipientaccount.md)>

---

<a id="find"></a>

### find

► **find**(recipientId: _`string`_, accountId: _`string`_): `RecipientAccount`(recipientaccount.md)>

_Defined in [RecipientAccountGateway.java:52](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientAccountGateway.java#L52)_

Fetch a specific account for a given Trolley recipient

RecipientAccount recipientAccount = client.recipientAccount.find("R-ad322121", "A-2134fd");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |
| accountId | `string`   |  The Trolley account ID (e.g. A-xyzzy) |

**Returns:** `RecipientAccount`(recipientaccount.md)>

---

<a id="delete"></a>

### delete

► **delete**(recipientId: _`string`_, accountId: _`string`_): `boolean`

_Defined in [RecipientAccountGateway.java:121](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientAccountGateway.java#L121)_

Delete the given recipient account. This will only return success, otherwise it will throw an exception (e.g. NotFound)

    RecipientAccount recipientAccount = client.recipientAccount.delete("R-ad322121", "A-2134fd");;

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |
| accountId | `string`   |  The Trolley account ID (e.g. A-xyzzy) |

**Returns:** `boolean`

---

<a id="update"></a>

### update

► **update**(recipientId: _`string`_, accountId: _`string`_, body: _`RecipientAccount`_): `RecipientAccount`(recipientaccount.md)>

_Defined in [RecipientAccountGateway.java:102](https://github.com/PaymentRails/java-sdk/tree/master/src/main/java/com/trolley/trolley/RecipientAccountGateway.java#L102)_

Update a recipient account. Note: Updating an account will create a new account ID if it contains any property that isn't just "primary"

    RecipientAccount recipientAccount = client.recipientAccount.update("R-ad322121", "A-2134fd", "{/"primary/":/"false/"}");

**Parameters:**

| Param | Type | Description |
| ------ | ------ | ------ |
| recipientId | `string`   |  The Trolley recipient ID (e.g. R-xyzzy) |
| accountId | `string`   |  The Trolley account ID (e.g. A-xyzzy) |
| body | `any`   |  Account information |

**Returns:** `RecipientAccount`(recipientaccount.md)>

---
