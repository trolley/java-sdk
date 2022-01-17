package com.trolley.trolley;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * <p>Recipient class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
@JsonInclude(Include.NON_NULL)
public class Recipient {

    String id;
    String routeType;
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
    public Object inactiveReasons;

    Compliance compliance;
    List<RecipientAccount> accounts;
    Address address;

    String taxForm;
    String taxFormStatus;
    String taxWithholdingPercentage = "0.0";

    /**
     * <p>Getter for the field <code>taxFormStatus</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTaxFormStatus() {
        return this.taxFormStatus;
    }

    /**
     * <p>Setter for the field <code>taxFormStatus</code>.</p>
     *
     * @param taxFormStatus a {@link java.lang.String} object.
     */
    public void setTaxFormStatus(String taxFormStatus) {
        this.taxFormStatus = taxForm;
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
     * <p>Getter for the field <code>taxWithholdingPercentage</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTaxWithholdingPercentage() {
        return this.taxWithholdingPercentage;
    }

    /**
     * <p>Setter for the field <code>taxWithholdingPercentage</code>.</p>
     *
     * @param taxWithholdingPercentage a {@link java.lang.String} object.
     */
    public void setTaxWithholdingPercentage(String taxWithholdingPercentage) {
        this.taxWithholdingPercentage = taxWithholdingPercentage;
    }

    /**
     * <p>Getter for the field <code>taxForm</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTaxForm() {
        return this.taxForm;
    }

    /**
     * <p>Setter for the field <code>taxForm</code>.</p>
     *
     * @param taxForm a {@link java.lang.String} object.
     */
    public void setTaxForm(String taxForm) {
        this.taxForm = taxForm;
    }

    /**
     * <p>Getter for the field <code>inactiveReasons</code>.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    public Object getInactiveReasons() {
        return inactiveReasons;
    }

    /**
     * <p>Setter for the field <code>inactiveReasons</code>.</p>
     *
     * @param inactiveReasons a {@link java.lang.Object} object.
     */
    public void setInactiveReasons(Object inactiveReasons) {
        this.inactiveReasons = inactiveReasons;
    }

    /**
     * <p>Getter for the field <code>accounts</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<RecipientAccount> getAccounts() {
        return accounts;
    }

    /**
     * <p>Setter for the field <code>accounts</code>.</p>
     *
     * @param accounts a {@link java.util.List} object.
     */
    public void setAccounts(List<RecipientAccount> accounts) {
        this.accounts = accounts;
    }

    /**
     * <p>Setter for the field <code>address</code>.</p>
     *
     * @param address a {@link com.trolley.trolley.Address} object.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * <p>Getter for the field <code>address</code>.</p>
     *
     * @return a {@link com.trolley.trolley.Address} object.
     */
    public Address getAddress() {
        return address;
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
     * <p>Getter for the field <code>lastName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * <p>Setter for the field <code>lastName</code>.</p>
     *
     * @param lastName a {@link java.lang.String} object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <p>Getter for the field <code>routeType</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRouteType() {
        return this.routeType;
    }

    /**
     * <p>Setter for the field <code>routeType</code>.</p>
     *
     * @param routeType a {@link java.lang.String} object.
     */
    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    /**
     * <p>Getter for the field <code>estimatedFees</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEstimatedFees() {
        return estimatedFees;
    }

    /**
     * <p>Setter for the field <code>estimatedFees</code>.</p>
     *
     * @param estimatedFees a {@link java.lang.String} object.
     */
    public void setEstimatedFees(String estimatedFees) {
        this.estimatedFees = estimatedFees;
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
     * <p>Getter for the field <code>referenceId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * <p>Setter for the field <code>referenceId</code>.</p>
     *
     * @param referenceId a {@link java.lang.String} object.
     */
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * <p>Getter for the field <code>email</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Setter for the field <code>email</code>.</p>
     *
     * @param email a {@link java.lang.String} object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter for the field <code>firstName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <p>Setter for the field <code>firstName</code>.</p>
     *
     * @param firstName a {@link java.lang.String} object.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <p>Getter for the field <code>type</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getType() {
        return type;
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link java.lang.String} object.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>Getter for the field <code>taxType</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTaxType() {
        return taxType;
    }

    /**
     * <p>Setter for the field <code>taxType</code>.</p>
     *
     * @param taxType a {@link java.lang.String} object.
     */
    public void setTaxType(String taxType) {
        this.taxType = taxType;
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
     * <p>Getter for the field <code>language</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <p>Setter for the field <code>language</code>.</p>
     *
     * @param language a {@link java.lang.String} object.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * <p>Getter for the field <code>complianceStatus</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getComplianceStatus() {
        return complianceStatus;
    }

    /**
     * <p>Setter for the field <code>complianceStatus</code>.</p>
     *
     * @param complianceStatus a {@link java.lang.String} object.
     */
    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    /**
     * <p>Getter for the field <code>dob</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDob() {
        return dob;
    }

    /**
     * <p>Setter for the field <code>dob</code>.</p>
     *
     * @param dob a {@link java.lang.String} object.
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * <p>Getter for the field <code>passport</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * <p>Setter for the field <code>passport</code>.</p>
     *
     * @param passport a {@link java.lang.String} object.
     */
    public void setPassport(String passport) {
        this.passport = passport;
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
     * <p>Getter for the field <code>gravatarUrl</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getGravatarUrl() {
        return gravatarUrl;
    }

    /**
     * <p>Setter for the field <code>gravatarUrl</code>.</p>
     *
     * @param gravatarUrl a {@link java.lang.String} object.
     */
    public void setGravatarUrl(String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }

    /**
     * <p>Getter for the field <code>governmentId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getGovernmentId() {
        return governmentId;
    }

    /**
     * <p>Setter for the field <code>governmentId</code>.</p>
     *
     * @param governmentId a {@link java.lang.String} object.
     */
    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    /**
     * <p>Getter for the field <code>ssn</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * <p>Setter for the field <code>ssn</code>.</p>
     *
     * @param ssn a {@link java.lang.String} object.
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * <p>Getter for the field <code>primaryCurrency</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    /**
     * <p>Setter for the field <code>primaryCurrency</code>.</p>
     *
     * @param primaryCurrency a {@link java.lang.String} object.
     */
    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    /**
     * <p>Getter for the field <code>placeOfBirth</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * <p>Setter for the field <code>placeOfBirth</code>.</p>
     *
     * @param placeOfBirth a {@link java.lang.String} object.
     */
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * <p>Getter for the field <code>merchantId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * <p>Setter for the field <code>merchantId</code>.</p>
     *
     * @param merchantId a {@link java.lang.String} object.
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
     * Retrieves a recipient based on the recipient id given
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @return The response
     * @throws java.lang.Exception if any.
     */
    public static Recipient find(String recipient_id) throws Exception {
        return Configuration.gateway().recipient.find(recipient_id);
    }

    /**
     * Retreives the recipient's logs based on the recipient id given
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @return the response
     * @throws java.lang.Exception if any.
     */
    public static String findLogs(String recipient_id) throws Exception {
        String response = Configuration.gateway().recipient.findLogs(recipient_id);
        return response;
    }

    /**
     * Retreives the recipient's payments based on the recipient id given
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @return the response
     * @throws java.lang.Exception if any.
     */
    public static List<Payment> findPayments(String recipient_id) throws Exception {
        return Configuration.gateway().recipient.findPayments(recipient_id);

    }

    /**
     * Creates a recipient based on the body given to the client
     *
     * @param body a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static Recipient create(String body) throws Exception {
        return Configuration.gateway().recipient.create(body);

    }

    /**
     * Updates a recipient based on the body given to the client
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static boolean update(String recipient_id, String body) throws Exception {
        return Configuration.gateway().recipient.update(recipient_id, body);
    }

    /**
     * Delete a recipient based on the recipient id
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws java.lang.Exception if any.
     */
    public static boolean delete(String recipient_id) throws Exception {
        return Configuration.gateway().recipient.delete(recipient_id);
    }

    /**
     * List all recipients based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param page
     * @param pageSize
     * @param pageSize a int.
     * @param term a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Recipient> search(int page, int pageSize, String term) throws Exception {
        return Configuration.gateway().recipient.search(page, pageSize, term);
    }

    /**
     * List all recipients based on the recipient id and a given wildcard
     *
     * @param message a {@link java.lang.String} object.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Recipient> search(String message) throws Exception {
        return search(1, 10, message);
    }

    /**
     * <p>search.</p>
     *
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Recipient> search() throws Exception {
        return search(1, 10, "");
    }

    /**
     * List all recipients based on the recipient id and (optional) page amount
     * and page size
     *
     * @param page
     * @param pageNumber
     * @param pageNumber a int.
     * @return The response
     * @throws com.trolley.Exceptions.InvalidStatusCodeException if any.
     * @throws com.trolley.Exceptions.InvalidServerConnectionException if any.
     * @throws com.trolley.Exceptions.InvalidFieldException if any.
     * @throws java.lang.Exception if any.
     */
    public static List<Recipient> search(int page, int pageNumber) throws Exception {
        return search(page, pageNumber, "");
    }

}
