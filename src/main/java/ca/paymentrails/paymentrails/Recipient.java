package ca.paymentrails.paymentrails;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.util.List;

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
    String merchantId;
    String payoutMethod;
    public Object payout;
    String emailAddress;

    Compliance compliance;
    List<RecipientAccount> accounts;
    Address address;

    public List<RecipientAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<RecipientAccount> accounts) {
        this.accounts = accounts;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Compliance getCompliance() {
        return compliance;
    }

    public void setCompliance(Compliance compliance) {
        this.compliance = compliance;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRouteType() {
        return this.routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getEstimatedFees() {
        return estimatedFees;
    }

    public void setEstimatedFees(String estimatedFees) {
        this.estimatedFees = estimatedFees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getGravatarUrl() {
        return gravatarUrl;
    }

    public void setGravatarUrl(String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayoutMethod() {
        return payoutMethod;
    }

    public void setPayoutMethod(String payoutMethod) {
        this.payoutMethod = payoutMethod;
    }

    /**
     * Retrieves a recipient based on the recipient id given
     *
     * @param recipient_id
     * @return The response
     * @throws Exception
    
     */

    public static Recipient find(String recipient_id) throws Exception {
        String response = Configuration.gateway().recipient.find(recipient_id);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        Recipient recipient = mapper.readValue(node.get("recipient").traverse(), Recipient.class);
        return recipient;
    }

    /**
     * Retreives the recipient's logs based on the recipient id given
     * 
     * @param recipient_id
     * @return the response
     * @throws Exception
     */
    public static String findLogs(String recipient_id) throws Exception {
        String response = Configuration.gateway().recipient.findLogs(recipient_id);
        return response;
    }

    /**
     * Retreives the recipient's payments based on the recipient id given
     * 
     * @param recipient_id
     * @return the response
     * @throws Exception
     */
    public static List<Payment> findPayments(String recipient_id) throws Exception {
        String response = Configuration.gateway().recipient.findPayments(recipient_id);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object payment = mapper.readValue(node.get("payments").traverse(), Object.class);
        @SuppressWarnings("unchecked")
        List<Payment> paymens = (List<Payment>) payment;
        List<Payment> payments = new ArrayList<Payment>();
        for (int i = 0; i < paymens.size(); i++) {
            Payment pojo = mapper.convertValue(paymens.get(i), Payment.class);
            payments.add(pojo);
        }

        return payments;
    }

    /**
     * Creates a recipient based on the body given to the client
     *
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static Recipient create(String body) throws Exception {
        String response = Configuration.gateway().recipient.create(body);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        Recipient recipient = mapper.readValue(node.get("recipient").traverse(), Recipient.class);
        return recipient;
    }

    /**
     * Updates a recipient based on the body given to the client
     *
     * @param recipient_id
     * @param body
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String update(String recipient_id, String body) throws Exception {
        return Configuration.gateway().recipient.update(recipient_id, body);
    }

    /**
     * Delete a recipient based on the recipient id
     *
     * @param recipient_id
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     */
    public static String delete(String recipient_id) throws Exception {
        return Configuration.gateway().recipient.delete(recipient_id);
    }

    /**
     * List all recipients based on the recipient id and (optional) a given
     * wildcard, page amount and page size
     *
     * @param page
     * @param pageSize
     * @param term
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Recipient> search(int page, int pageSize, String term) throws Exception {
        String response = Configuration.gateway().recipient.search(page, pageSize, term);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);

        Object recipient = mapper.readValue(node.get("recipients").traverse(), Object.class);
        @SuppressWarnings("unchecked")
        List<Recipient> recips = (List<Recipient>) recipient;
        List<Recipient> recipients = new ArrayList<Recipient>();
        for (int i = 0; i < recips.size(); i++) {
            Recipient pojo = mapper.convertValue(recips.get(i), Recipient.class);
            recipients.add(pojo);
        }
        return recipients;
    }

    /**
     * List all recipients based on the recipient id and a given wildcard
     *
     * @param message
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Recipient> search(String message) throws Exception {
        return search(1, 10, message);
    }

    /**
     * 
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException 
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException 
     * @throws ca.paymentrails.Exceptions.InvalidFieldException 
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
     * @return The response
     * @throws ca.paymentrails.Exceptions.InvalidStatusCodeException
     * @throws ca.paymentrails.Exceptions.InvalidConnectionException
     * @throws ca.paymentrails.Exceptions.InvalidFieldException
     */
    public static List<Recipient> search(int page, int pageNumber) throws Exception {
        return search(page, pageNumber, "");
    }

}
