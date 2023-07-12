package com.trolley.trolley;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipient
{
    String id;
    String routeType;
    String routeMinimum;
    String estimatedFees;
    String referenceId;
    String email;
    String name;
    String lastName;
    String firstName;
    String type;
    String taxType;
    String status;
    String language;
    String complianceStatus;
    String dob;
    String passport;
    String updatedAt;
    String createdAt;
    String gravatarUrl;
    String governmentId;
    String ssn;
    String primaryCurrency;
    String placeOfBirth;
    List<String> tags;
    String merchantId;
    String payoutMethod;
    public Object payout;
    String emailAddress;
    List<String> contactEmails;
    public Object inactiveReasons;
    Compliance compliance;
    List<RecipientAccount> accounts;
    Address address;
    String taxForm;
    String taxFormStatus;
    String taxWithholdingPercentage;
    
    public Recipient() {
        this.taxWithholdingPercentage = "0.0";
    }
    
    public String getTaxFormStatus() {
        return this.taxFormStatus;
    }
    
    public void setTaxFormStatus(final String taxFormStatus) {
        this.taxFormStatus = this.taxForm;
    }
    
    public List<String> getTags() {
        return this.tags;
    }
    
    public void setTags(final List<String> tags) {
        this.tags = tags;
    }
    
    public String getTaxWithholdingPercentage() {
        return this.taxWithholdingPercentage;
    }
    
    public void setTaxWithholdingPercentage(final String taxWithholdingPercentage) {
        this.taxWithholdingPercentage = taxWithholdingPercentage;
    }
    
    public String getTaxForm() {
        return this.taxForm;
    }
    
    public void setTaxForm(final String taxForm) {
        this.taxForm = taxForm;
    }
    
    public Object getInactiveReasons() {
        return this.inactiveReasons;
    }
    
    public void setInactiveReasons(final Object inactiveReasons) {
        this.inactiveReasons = inactiveReasons;
    }
    
    public List<RecipientAccount> getAccounts() {
        return this.accounts;
    }
    
    public void setAccounts(final List<RecipientAccount> accounts) {
        this.accounts = accounts;
    }
    
    public void setAddress(final Address address) {
        this.address = address;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public Compliance getCompliance() {
        return this.compliance;
    }
    
    public void setCompliance(final Compliance compliance) {
        this.compliance = compliance;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
    public String getRouteType() {
        return this.routeType;
    }
    
    public void setRouteType(final String routeType) {
        this.routeType = routeType;
    }

    public String getRouteMinimum() {
        return this.routeMinimum;
    }

    public void setRouteMinimum(String routeMinimum) {
        this.routeMinimum = routeMinimum;
    }
    
    public String getEstimatedFees() {
        return this.estimatedFees;
    }
    
    public void setEstimatedFees(final String estimatedFees) {
        this.estimatedFees = estimatedFees;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getReferenceId() {
        return this.referenceId;
    }
    
    public void setReferenceId(final String referenceId) {
        this.referenceId = referenceId;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }

    public List<String> getContactEmails() {
        return this.contactEmails;
    }

    public void setContactEmails(final List<String> contactEmails) {
        this.contactEmails = contactEmails;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getTaxType() {
        return this.taxType;
    }
    
    public void setTaxType(final String taxType) {
        this.taxType = taxType;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getLanguage() {
        return this.language;
    }
    
    public void setLanguage(final String language) {
        this.language = language;
    }
    
    public String getComplianceStatus() {
        return this.complianceStatus;
    }
    
    public void setComplianceStatus(final String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }
    
    public String getDob() {
        return this.dob;
    }
    
    public void setDob(final String dob) {
        this.dob = dob;
    }
    
    public String getPassport() {
        return this.passport;
    }
    
    public void setPassport(final String passport) {
        this.passport = passport;
    }
    
    public String getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(final String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getGravatarUrl() {
        return this.gravatarUrl;
    }
    
    public void setGravatarUrl(final String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }
    
    public String getGovernmentId() {
        return this.governmentId;
    }
    
    public void setGovernmentId(final String governmentId) {
        this.governmentId = governmentId;
    }
    
    public String getSsn() {
        return this.ssn;
    }
    
    public void setSsn(final String ssn) {
        this.ssn = ssn;
    }
    
    public String getPrimaryCurrency() {
        return this.primaryCurrency;
    }
    
    public void setPrimaryCurrency(final String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }
    
    public String getPlaceOfBirth() {
        return this.placeOfBirth;
    }
    
    public void setPlaceOfBirth(final String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
    
    public String getMerchantId() {
        return this.merchantId;
    }
    
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }
    
    public String getPayoutMethod() {
        return this.payoutMethod;
    }
    
    public void setPayoutMethod(final String payoutMethod) {
        this.payoutMethod = payoutMethod;
    }
    
    public static Recipient find(final String recipient_id) throws Exception {
        return Configuration.gateway().recipient.find(recipient_id);
    }
    
    public static String findLogs(final String recipient_id) throws Exception {
        final String response = Configuration.gateway().recipient.findLogs(recipient_id);
        return response;
    }
    
    public static List<Payment> findPayments(final String recipient_id) throws Exception {
        return Configuration.gateway().recipient.findPayments(recipient_id);
    }
    
    public static Recipient create(final String body) throws Exception {
        return Configuration.gateway().recipient.create(body);
    }
    
    public static boolean update(final String recipient_id, final String body) throws Exception {
        return Configuration.gateway().recipient.update(recipient_id, body);
    }
    
    public static boolean delete(final String recipient_id) throws Exception {
        return Configuration.gateway().recipient.delete(recipient_id);
    }
    
    public static List<Recipient> search(final int page, final int pageSize, final String term) throws Exception {
        return Configuration.gateway().recipient.search(page, pageSize, term);
    }
    
    public static List<Recipient> search(final String message) throws Exception {
        return search(1, 10, message);
    }
    
    public static List<Recipient> search() throws Exception {
        return search(1, 10, "");
    }
    
    public static List<Recipient> search(final int page, final int pageNumber) throws Exception {
        return search(page, pageNumber, "");
    }
}
