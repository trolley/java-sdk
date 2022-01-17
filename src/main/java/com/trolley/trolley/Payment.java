package com.trolley.trolley;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * <p>Payment class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
@JsonInclude(Include.NON_NULL)
public class Payment {

    private String id;
    private Recipient recipient;
    private String status;
    private Boolean isSupplyPayment;
    private String returnedAmount;

    private String amount;
    private String currency;
    private String category;
    private RecipientAccount account;
    private List<String> tags;

    private String sourceAmount;
    private String sourceCurrency;
    private String targetAmount;
    private String targetCurrency;
    private String exchangeRate;
    private String fees;
    private String recipientFees;
    private String fxRate;
    private String memo;
    private String externalId;
    private Object processedAt;
    private String createdAt;
    private String updatedAt;
    private String merchantFees;
    private Compliance compliance;
    private String payoutMethod;
    private String methodDisplay;
    Object batch;

    String withholdingAmount;
    String withholdingCurrency;
    String equivalentWithholdingAmount;
    String equivalentWithholdingCurrency;

    /**
     * <p>Setter for the field <code>equivalentWithholdingCurrency</code>.</p>
     *
     * @param equivalentWithholdingCurrency a {@link java.lang.String} object.
     */
    public void setEquivalentWithholdingCurrency(String equivalentWithholdingCurrency) {
        this.equivalentWithholdingCurrency = equivalentWithholdingCurrency;
    }

    /**
     * <p>Getter for the field <code>equivalentWithholdingCurrency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEquivalentWithholdingCurrency() {
        return equivalentWithholdingCurrency;
    }

    /**
     * <p>Setter for the field <code>equivalentWithholdingAmount</code>.</p>
     *
     * @param equivalentWithholdingAmount a {@link java.lang.String} object.
     */
    public void setEquivalentWithholdingAmount(String equivalentWithholdingAmount) {
        this.equivalentWithholdingAmount = equivalentWithholdingAmount;
    }

    /**
     * <p>Getter for the field <code>equivalentWithholdingAmount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEquivalentWithholdingAmount() {
        return equivalentWithholdingAmount;
    }

    /**
     * <p>Setter for the field <code>withholdingCurrency</code>.</p>
     *
     * @param withholdingCurrency a {@link java.lang.String} object.
     */
    public void setWithholdingCurrency(String withholdingCurrency) {
        this.withholdingCurrency = withholdingCurrency;
    }

    /**
     * <p>Getter for the field <code>tags</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getTags() {
        return this.tags;
    }

    /**
     * <p>Setter for the field <code>tags</code>.</p>
     *
     * @param tags a {@link java.util.List} object.
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * <p>Getter for the field <code>account</code>.</p>
     *
     * @return a {@link com.trolley.trolley.RecipientAccount} object.
     */
    public RecipientAccount getAccount() {
        return account;
    }

    /**
     * <p>Setter for the field <code>account</code>.</p>
     *
     * @param account a {@link com.trolley.trolley.RecipientAccount} object.
     */
    public void setAccount(RecipientAccount account) {
        this.account = account;
    }

    /**
     * <p>Getter for the field <code>category</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCategory() {
        return category;
    }

    /**
     * <p>Setter for the field <code>category</code>.</p>
     *
     * @param category a {@link java.lang.String} object.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * <p>Getter for the field <code>currency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * <p>Setter for the field <code>currency</code>.</p>
     *
     * @param currency a {@link java.lang.String} object.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * <p>Getter for the field <code>amount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * <p>Setter for the field <code>amount</code>.</p>
     *
     * @param amount a {@link java.lang.String} object.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * <p>Getter for the field <code>withholdingCurrency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getWithholdingCurrency() {
        return withholdingCurrency;
    }

    /**
     * <p>Setter for the field <code>withholdingAmount</code>.</p>
     *
     * @param withholdingAmount a {@link java.lang.String} object.
     */
    public void setWithholdingAmount(String withholdingAmount) {
        this.withholdingAmount = withholdingAmount;
    }

    /**
     * <p>Getter for the field <code>withholdingAmount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getWithholdingAmount() {
        return withholdingAmount;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>recipient</code>.</p>
     *
     * @return a {@link com.trolley.trolley.Recipient} object.
     */
    public Recipient getRecipient() {
        return recipient;
    }

    /**
     * <p>Setter for the field <code>recipient</code>.</p>
     *
     * @param recipient a {@link com.trolley.trolley.Recipient} object.
     */
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    /**
     * <p>Getter for the field <code>status</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStatus() {
        return status;
    }

    /**
     * <p>Setter for the field <code>status</code>.</p>
     *
     * @param status a {@link java.lang.String} object.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * <p>Getter for the field <code>isSupplyPayment</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIsSupplyPayment() {
        return isSupplyPayment;
    }

    /**
     * <p>Setter for the field <code>isSupplyPayment</code>.</p>
     *
     * @param isSupplyPayment a {@link java.lang.Boolean} object.
     */
    public void setIsSupplyPayment(Boolean isSupplyPayment) {
        this.isSupplyPayment = isSupplyPayment;
    }

    /**
     * <p>Getter for the field <code>returnedAmount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReturnedAmount() {
        return returnedAmount;
    }

    /**
     * <p>Setter for the field <code>returnedAmount</code>.</p>
     *
     * @param returnedAmount a {@link java.lang.String} object.
     */
    public void setReturnedAmount(String returnedAmount) {
        this.returnedAmount = returnedAmount;
    }

    /**
     * <p>Getter for the field <code>sourceAmount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSourceAmount() {
        return sourceAmount;
    }

    /**
     * <p>Setter for the field <code>sourceAmount</code>.</p>
     *
     * @param sourceAmount a {@link java.lang.String} object.
     */
    public void setSourceAmount(String sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    /**
     * <p>Getter for the field <code>sourceCurrency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * <p>Setter for the field <code>sourceCurrency</code>.</p>
     *
     * @param sourceCurrency a {@link java.lang.String} object.
     */
    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    /**
     * <p>Getter for the field <code>targetAmount</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTargetAmount() {
        return targetAmount;
    }

    /**
     * <p>Setter for the field <code>targetAmount</code>.</p>
     *
     * @param targetAmount a {@link java.lang.String} object.
     */
    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    /**
     * <p>Getter for the field <code>targetCurrency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * <p>Setter for the field <code>targetCurrency</code>.</p>
     *
     * @param targetCurrency a {@link java.lang.String} object.
     */
    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    /**
     * <p>Getter for the field <code>exchangeRate</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getExchangeRate() {
        return exchangeRate;
    }

    /**
     * <p>Setter for the field <code>exchangeRate</code>.</p>
     *
     * @param exchangeRate a {@link java.lang.String} object.
     */
    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * <p>Getter for the field <code>fees</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFees() {
        return fees;
    }

    /**
     * <p>Setter for the field <code>fees</code>.</p>
     *
     * @param fees a {@link java.lang.String} object.
     */
    public void setFees(String fees) {
        this.fees = fees;
    }

    /**
     * <p>Getter for the field <code>recipientFees</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRecipientFees() {
        return recipientFees;
    }

    /**
     * <p>Setter for the field <code>recipientFees</code>.</p>
     *
     * @param recipientFees a {@link java.lang.String} object.
     */
    public void setRecipientFees(String recipientFees) {
        this.recipientFees = recipientFees;
    }

    /**
     * <p>Getter for the field <code>fxRate</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFxRate() {
        return fxRate;
    }

    /**
     * <p>Setter for the field <code>fxRate</code>.</p>
     *
     * @param fxRate a {@link java.lang.String} object.
     */
    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    /**
     * <p>Getter for the field <code>memo</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMemo() {
        return memo;
    }

    /**
     * <p>Setter for the field <code>memo</code>.</p>
     *
     * @param memo a {@link java.lang.String} object.
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * <p>Getter for the field <code>externalId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * <p>Setter for the field <code>externalId</code>.</p>
     *
     * @param externalId a {@link java.lang.String} object.
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * <p>Getter for the field <code>processedAt</code>.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    public Object getProcessedAt() {
        return processedAt;
    }

    /**
     * <p>Setter for the field <code>processedAt</code>.</p>
     *
     * @param processedAt a {@link java.lang.Object} object.
     */
    public void setProcessedAt(Object processedAt) {
        this.processedAt = processedAt;
    }

    /**
     * <p>Getter for the field <code>createdAt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * <p>Setter for the field <code>createdAt</code>.</p>
     *
     * @param createdAt a {@link java.lang.String} object.
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * <p>Getter for the field <code>updatedAt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * <p>Setter for the field <code>updatedAt</code>.</p>
     *
     * @param updatedAt a {@link java.lang.String} object.
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * <p>Getter for the field <code>merchantFees</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMerchantFees() {
        return merchantFees;
    }

    /**
     * <p>Setter for the field <code>merchantFees</code>.</p>
     *
     * @param merchantFees a {@link java.lang.String} object.
     */
    public void setMerchantFees(String merchantFees) {
        this.merchantFees = merchantFees;
    }

    /**
     * <p>Getter for the field <code>compliance</code>.</p>
     *
     * @return a {@link com.trolley.trolley.Compliance} object.
     */
    public Compliance getCompliance() {
        return compliance;
    }

    /**
     * <p>Setter for the field <code>compliance</code>.</p>
     *
     * @param compliance a {@link com.trolley.trolley.Compliance} object.
     */
    public void setCompliance(Compliance compliance) {
        this.compliance = compliance;
    }

    /**
     * <p>Getter for the field <code>payoutMethod</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPayoutMethod() {
        return payoutMethod;
    }

    /**
     * <p>Setter for the field <code>payoutMethod</code>.</p>
     *
     * @param payoutMethod a {@link java.lang.String} object.
     */
    public void setPayoutMethod(String payoutMethod) {
        this.payoutMethod = payoutMethod;
    }

    /**
     * <p>Getter for the field <code>methodDisplay</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMethodDisplay() {
        return methodDisplay;
    }

    /**
     * <p>Setter for the field <code>methodDisplay</code>.</p>
     *
     * @param methodDisplay a {@link java.lang.String} object.
     */
    public void setMethodDisplay(String methodDisplay) {
        this.methodDisplay = methodDisplay;
    }

    /**
     * Retrieves a batch based on the batch id
     *
     * @param payment_id a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static Payment find(String payment_id, String batch_id) throws Exception {
        return Configuration.gateway().payment.find(payment_id, batch_id);
    }

    /**
     * Creates a payment based on the body and batch id
     *
     * @param body a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static Payment create(String body, String batch_id) throws Exception {
        return Configuration.gateway().payment.create(body, batch_id);
    }

    /**
     * Updates a payment based on the payment id, body and batch id
     *
     * @param payment_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static boolean update(String payment_id, String body, String batch_id) throws Exception {
        return Configuration.gateway().payment.update(payment_id, body, batch_id);
    }

    /**
     * Deletes a payment based on the payment id and batch id
     *
     * @param payment_id a {@link java.lang.String} object.
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static boolean delete(String payment_id, String batch_id) throws Exception {
        return Configuration.gateway().payment.delete(payment_id, batch_id);
    }

    /**
     * List all payments based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param page
     * @param pageSize
     * @param pageSize a int.
     * @param message a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Payment> query(String batch_id, int page, int pageSize, String message) throws Exception {

        return Configuration.gateway().payment.query(batch_id, page, pageSize, message);

    }

    /**
     * List all payments based on the recipient id and a given wildcard
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param message a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Payment> query(String batch_id, String message) throws Exception {
        return query(batch_id, 1, 10, message);
    }

    /**
     * List all payments
     *
     * @param batch_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Payment> query(String batch_id) throws Exception {
        return query(batch_id, 1, 10, "");
    }

    /**
     * List all payments based on the recipient id and (optional) page amount
     * and page size
     *
     * @param batch_id a {@link java.lang.String} object.
     * @param page
     * @param pageSize
     * @param pageSize a int.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Payment> query(String batch_id, int page, int pageSize) throws Exception {

        return query(batch_id, page, pageSize, "");
    }
}

// class PaymentSerializer extends JsonSerializer<List<Payment>> {

//     @Override
//     public void serialize(List<Payment> value, JsonGenerator jgen,
//             SerializerProvider provider) throws IOException {
//         jgen.writeStartArray();
//         for (Payment payment : value) {
//             jgen.writeStartObject();
//             jgen.writeObjectField("payment", payment);
//             jgen.writeEndObject();    
//         }
//         jgen.writeEndArray();
//     }

// }
