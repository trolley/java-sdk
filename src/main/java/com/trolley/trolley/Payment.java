package com.trolley.trolley;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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

    public void setEquivalentWithholdingCurrency(String equivalentWithholdingCurrency) {
        this.equivalentWithholdingCurrency = equivalentWithholdingCurrency;
    }

    public String getEquivalentWithholdingCurrency() {
        return equivalentWithholdingCurrency;
    }

    public void setEquivalentWithholdingAmount(String equivalentWithholdingAmount) {
        this.equivalentWithholdingAmount = equivalentWithholdingAmount;
    }

    public String getEquivalentWithholdingAmount() {
        return equivalentWithholdingAmount;
    }

    public void setWithholdingCurrency(String withholdingCurrency) {
        this.withholdingCurrency = withholdingCurrency;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public RecipientAccount getAccount() {
        return account;
    }

    public void setAccount(RecipientAccount account) {
        this.account = account;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWithholdingCurrency() {
        return withholdingCurrency;
    }

    public void setWithholdingAmount(String withholdingAmount) {
        this.withholdingAmount = withholdingAmount;
    }

    public String getWithholdingAmount() {
        return withholdingAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsSupplyPayment() {
        return isSupplyPayment;
    }

    public void setIsSupplyPayment(Boolean isSupplyPayment) {
        this.isSupplyPayment = isSupplyPayment;
    }

    public String getReturnedAmount() {
        return returnedAmount;
    }

    public void setReturnedAmount(String returnedAmount) {
        this.returnedAmount = returnedAmount;
    }

    public String getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(String sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getRecipientFees() {
        return recipientFees;
    }

    public void setRecipientFees(String recipientFees) {
        this.recipientFees = recipientFees;
    }

    public String getFxRate() {
        return fxRate;
    }

    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Object getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Object processedAt) {
        this.processedAt = processedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMerchantFees() {
        return merchantFees;
    }

    public void setMerchantFees(String merchantFees) {
        this.merchantFees = merchantFees;
    }

    public Compliance getCompliance() {
        return compliance;
    }

    public void setCompliance(Compliance compliance) {
        this.compliance = compliance;
    }

    public String getPayoutMethod() {
        return payoutMethod;
    }

    public void setPayoutMethod(String payoutMethod) {
        this.payoutMethod = payoutMethod;
    }

    public String getMethodDisplay() {
        return methodDisplay;
    }

    public void setMethodDisplay(String methodDisplay) {
        this.methodDisplay = methodDisplay;
    }

    /**
     * Retrieves a batch based on the batch id
     *
     * @param payment_id
     * @param batch_id
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static Payment find(String payment_id, String batch_id) throws Exception {
        return Configuration.gateway().payment.find(payment_id, batch_id);
    }

    /**
     * Creates a payment based on the body and batch id
     *
     * @param body
     * @param batch_id
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static Payment create(String body, String batch_id) throws Exception {
        return Configuration.gateway().payment.create(body, batch_id);
    }

    /**
     * Updates a payment based on the payment id, body and batch id
     *
     * @param payment_id
     * @param body
     * @param batch_id
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static boolean update(String payment_id, String body, String batch_id) throws Exception {
        return Configuration.gateway().payment.update(payment_id, body, batch_id);
    }

    /**
     * Deletes a payment based on the payment id and batch id
     *
     * @param payment_id
     * @param batch_id
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static boolean delete(String payment_id, String batch_id) throws Exception {
        return Configuration.gateway().payment.delete(payment_id, batch_id);
    }

    /**
     * List all payments based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param batch_id
     * @param page
     * @param pageSize
     * @param message
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static List<Payment> query(String batch_id, int page, int pageSize, String message) throws Exception {

        return Configuration.gateway().payment.query(batch_id, page, pageSize, message);

    }

    /**
     * List all payments based on the recipient id and a given wildcard
     *
     * @param batch_id
     * @param message
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static List<Payment> query(String batch_id, String message) throws Exception {
        return query(batch_id, 1, 10, message);
    }

    /**
     * List all payments
     *
     * @param batch_id
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
     */
    public static List<Payment> query(String batch_id) throws Exception {
        return query(batch_id, 1, 10, "");
    }

    /**
     * List all payments based on the recipient id and (optional) page amount
     * and page size
     *
     * @param batch_id
     * @param page
     * @param pageSize
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException
     * @throws com.trolley.Exceptions.InvalidConnectionException
     * @throws com.trolley.Exceptions.InvalidFieldException
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