package com.trolley.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trolley.Configuration;
import com.trolley.types.supporting.Compliance;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment
{
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
    private String processedAt;
    private String createdAt;
    private String updatedAt;
    private String merchantFees;
    private Compliance compliance;
    private String payoutMethod;
    private String methodDisplay;
    private Batch batch;
    private String checkNumber;
    private String withholdingAmount;
    private String withholdingCurrency;
    private String equivalentWithholdingAmount;
    private String equivalentWithholdingCurrency;
    private boolean coverFees;
    private List<String> errors;
    private String estimatedDeliveryAt;
    private boolean forceUsTaxActivity;
    private String initiatedAt;
    private String merchantId;
    private String returnedAt;
    private String returnedNote;
    private List<String> returnedReason;
    private String routeMinimum;
    private String routeType;
    private String settledAt;
    private String taxBasisAmount;
    private String taxBasisCurrency;
    private boolean taxReportable;
    
    public void setEquivalentWithholdingCurrency(final String equivalentWithholdingCurrency) {
        this.equivalentWithholdingCurrency = equivalentWithholdingCurrency;
    }
    
    public String getEquivalentWithholdingCurrency() {
        return this.equivalentWithholdingCurrency;
    }
    
    public void setEquivalentWithholdingAmount(final String equivalentWithholdingAmount) {
        this.equivalentWithholdingAmount = equivalentWithholdingAmount;
    }
    
    public String getEquivalentWithholdingAmount() {
        return this.equivalentWithholdingAmount;
    }
    
    public void setWithholdingCurrency(final String withholdingCurrency) {
        this.withholdingCurrency = withholdingCurrency;
    }
    
    public List<String> getTags() {
        return this.tags;
    }
    
    public void setTags(final List<String> tags) {
        this.tags = tags;
    }
    
    public RecipientAccount getAccount() {
        return this.account;
    }
    
    public void setAccount(final RecipientAccount account) {
        this.account = account;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(final String category) {
        this.category = category;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public String getWithholdingCurrency() {
        return this.withholdingCurrency;
    }
    
    public void setWithholdingAmount(final String withholdingAmount) {
        this.withholdingAmount = withholdingAmount;
    }
    
    public String getWithholdingAmount() {
        return this.withholdingAmount;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public Recipient getRecipient() {
        return this.recipient;
    }
    
    public void setRecipient(final Recipient recipient) {
        this.recipient = recipient;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public Boolean getIsSupplyPayment() {
        return this.isSupplyPayment;
    }
    
    public void setIsSupplyPayment(final Boolean isSupplyPayment) {
        this.isSupplyPayment = isSupplyPayment;
    }
    
    public String getReturnedAmount() {
        return this.returnedAmount;
    }
    
    public void setReturnedAmount(final String returnedAmount) {
        this.returnedAmount = returnedAmount;
    }
    
    public String getSourceAmount() {
        return this.sourceAmount;
    }
    
    public void setSourceAmount(final String sourceAmount) {
        this.sourceAmount = sourceAmount;
    }
    
    public String getSourceCurrency() {
        return this.sourceCurrency;
    }
    
    public void setSourceCurrency(final String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }
    
    public String getTargetAmount() {
        return this.targetAmount;
    }
    
    public void setTargetAmount(final String targetAmount) {
        this.targetAmount = targetAmount;
    }
    
    public String getTargetCurrency() {
        return this.targetCurrency;
    }
    
    public void setTargetCurrency(final String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
    
    public String getExchangeRate() {
        return this.exchangeRate;
    }
    
    public void setExchangeRate(final String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    
    public String getFees() {
        return this.fees;
    }
    
    public void setFees(final String fees) {
        this.fees = fees;
    }
    
    public String getRecipientFees() {
        return this.recipientFees;
    }
    
    public void setRecipientFees(final String recipientFees) {
        this.recipientFees = recipientFees;
    }
    
    public String getFxRate() {
        return this.fxRate;
    }
    
    public void setFxRate(final String fxRate) {
        this.fxRate = fxRate;
    }
    
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(final String memo) {
        this.memo = memo;
    }
    
    public String getExternalId() {
        return this.externalId;
    }
    
    public void setExternalId(final String externalId) {
        this.externalId = externalId;
    }
    
    public String getProcessedAt() {
        return this.processedAt;
    }
    
    public void setProcessedAt(final String processedAt) {
        this.processedAt = processedAt;
    }
    
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(final String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getMerchantFees() {
        return this.merchantFees;
    }
    
    public void setMerchantFees(final String merchantFees) {
        this.merchantFees = merchantFees;
    }
    
    public Compliance getCompliance() {
        return this.compliance;
    }
    
    public void setCompliance(final Compliance compliance) {
        this.compliance = compliance;
    }
    
    public String getPayoutMethod() {
        return this.payoutMethod;
    }
    
    public void setPayoutMethod(final String payoutMethod) {
        this.payoutMethod = payoutMethod;
    }
    
    public String getMethodDisplay() {
        return this.methodDisplay;
    }
    
    public void setMethodDisplay(final String methodDisplay) {
        this.methodDisplay = methodDisplay;
    }
    
    public Batch getBatch() {
        return batch;
    }

    public void setBatch(final Batch batch) {
        this.batch = batch;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(final String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public boolean isCoverFees() {
        return coverFees;
    }

    public void setCoverFees(final boolean coverFees) {
        this.coverFees = coverFees;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    public String getEstimatedDeliveryAt() {
        return estimatedDeliveryAt;
    }

    public void setEstimatedDeliveryAt(final String estimatedDeliveryAt) {
        this.estimatedDeliveryAt = estimatedDeliveryAt;
    }

    public boolean isForceUsTaxActivity() {
        return forceUsTaxActivity;
    }

    public void setForceUsTaxActivity(final boolean forceUsTaxActivity) {
        this.forceUsTaxActivity = forceUsTaxActivity;
    }

    public String getInitiatedAt() {
        return initiatedAt;
    }

    public void setInitiatedAt(final String initiatedAt) {
        this.initiatedAt = initiatedAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    public String getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(final String returnedAt) {
        this.returnedAt = returnedAt;
    }

    public String getReturnedNote() {
        return returnedNote;
    }

    public void setReturnedNote(final String returnedNote) {
        this.returnedNote = returnedNote;
    }

    public List<String> getReturnedReason() {
        return returnedReason;
    }

    public void setReturnedReason(final List<String> returnedReason) {
        this.returnedReason = returnedReason;
    }

    public String getRouteMinimum() {
        return routeMinimum;
    }

    public void setRouteMinimum(final String routeMinimum) {
        this.routeMinimum = routeMinimum;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(final String routeType) {
        this.routeType = routeType;
    }

    public String getSettledAt() {
        return settledAt;
    }

    public void setSettledAt(final String settledAt) {
        this.settledAt = settledAt;
    }

    public String getTaxBasisAmount() {
        return taxBasisAmount;
    }

    public void setTaxBasisAmount(final String taxBasisAmount) {
        this.taxBasisAmount = taxBasisAmount;
    }

    public String getTaxBasisCurrency() {
        return taxBasisCurrency;
    }

    public void setTaxBasisCurrency(final String taxBasisCurrency) {
        this.taxBasisCurrency = taxBasisCurrency;
    }

    public boolean isTaxReportable() {
        return taxReportable;
    }

    public void setTaxReportable(final boolean taxReportable) {
        this.taxReportable = taxReportable;
    }

    public static Payment find(final String payment_id, final String batch_id) throws Exception {
        return Configuration.gateway().payment.find(payment_id, batch_id);
    }
    
    public static Payment create(final String body, final String batch_id) throws Exception {
        return Configuration.gateway().payment.create(body, batch_id);
    }
    
    public static boolean update(final String payment_id, final String body, final String batch_id) throws Exception {
        return Configuration.gateway().payment.update(payment_id, body, batch_id);
    }
    
    public static boolean delete(final String payment_id, final String batch_id) throws Exception {
        return Configuration.gateway().payment.delete(payment_id, batch_id);
    }
    
    /* public static List<Payment> query(final String batch_id, final int page, final int pageSize, final String message) throws Exception {
        return Configuration.gateway().payment.query(batch_id, page, pageSize, message);
    }
    
    public static List<Payment> query(final String batch_id, final String message) throws Exception {
        return query(batch_id, 1, 10, message);
    }
    
    public static List<Payment> query(final String batch_id) throws Exception {
        return query(batch_id, 1, 10, "");
    }
    
    public static List<Payment> query(final String batch_id, final int page, final int pageSize) throws Exception {
        return query(batch_id, page, pageSize, ""); 
    }*/
}
