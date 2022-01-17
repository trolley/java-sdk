package com.trolley.trolley;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;;

/**
 * <p>RecipientAccount class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
@JsonInclude(Include.NON_NULL)
public class RecipientAccount {

    String type;
    Boolean primary;
    String currency;
    String id;
    String recipientId;
    String recipientAccountId;
    String routeType;
    String recipientFees;
    String country;
    String iban;
    String accountNum;
    String accountHolderName;
    String swiftBic;
    String branchId;
    String bankId;
    String bankName;
    String bankAddress;
    String bankCity;
    String bankRegionCode;
    String bankPostalCode;
    String emailAddress;
    String status;
    String disabledAt;

    /**
     * <p>Getter for the field <code>emailAddress</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEmailAddress(){
        return emailAddress;
    }
    /**
     * <p>Setter for the field <code>emailAddress</code>.</p>
     *
     * @param emailAddress a {@link java.lang.String} object.
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }


    /**
     * <p>Getter for the field <code>disabledAt</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDisabledAt(){
        return disabledAt;
    }
    /**
     * <p>Setter for the field <code>disabledAt</code>.</p>
     *
     * @param disabledAt a {@link java.lang.String} object.
     */
    public void setDisabledAt(String disabledAt){
        this.disabledAt = disabledAt;
    }

    /**
     * <p>Getter for the field <code>status</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStatus(){
        return status;
    }
    /**
     * <p>Setter for the field <code>status</code>.</p>
     *
     * @param status a {@link java.lang.String} object.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * <p>Getter for the field <code>recipientId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRecipientId(){
        return recipientId;
    }
    /**
     * <p>Setter for the field <code>recipientId</code>.</p>
     *
     * @param recipientId a {@link java.lang.String} object.
     */
    public void setRecipientId(String recipientId){
        this.recipientId = recipientId;
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
     * <p>Getter for the field <code>primary</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getPrimary() {
        return primary;
    }

    /**
     * <p>Setter for the field <code>primary</code>.</p>
     *
     * @param primary a {@link java.lang.Boolean} object.
     */
    public void setPrimary(Boolean primary) {
        this.primary = primary;
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
     * <p>Getter for the field <code>recipientAccountId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRecipientAccountId() {
        return recipientAccountId;
    }

    /**
     * <p>Setter for the field <code>recipientAccountId</code>.</p>
     *
     * @param recipientAccountId a {@link java.lang.String} object.
     */
    public void setRecipientAccountId(String recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }

    /**
     * <p>Getter for the field <code>routeType</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRouteType() {
        return routeType;
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
     * <p>Getter for the field <code>country</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>Setter for the field <code>country</code>.</p>
     *
     * @param country a {@link java.lang.String} object.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <p>Getter for the field <code>iban</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIban() {
        return iban;
    }

    /**
     * <p>Setter for the field <code>iban</code>.</p>
     *
     * @param iban a {@link java.lang.String} object.
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * <p>Getter for the field <code>accountNum</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * <p>Setter for the field <code>accountNum</code>.</p>
     *
     * @param accountNum a {@link java.lang.String} object.
     */
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    /**
     * <p>Getter for the field <code>accountHolderName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * <p>Setter for the field <code>accountHolderName</code>.</p>
     *
     * @param accountHolderName a {@link java.lang.String} object.
     */
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    /**
     * <p>Getter for the field <code>swiftBic</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSwiftBic() {
        return swiftBic;
    }

    /**
     * <p>Setter for the field <code>swiftBic</code>.</p>
     *
     * @param swiftBic a {@link java.lang.String} object.
     */
    public void setSwiftBic(String swiftBic) {
        this.swiftBic = swiftBic;
    }

    /**
     * <p>Getter for the field <code>branchId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBranchId() {
        return branchId;
    }

    /**
     * <p>Setter for the field <code>branchId</code>.</p>
     *
     * @param branchId a {@link java.lang.String} object.
     */
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    /**
     * <p>Getter for the field <code>bankId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * <p>Setter for the field <code>bankId</code>.</p>
     *
     * @param bankId a {@link java.lang.String} object.
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * <p>Getter for the field <code>bankName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * <p>Setter for the field <code>bankName</code>.</p>
     *
     * @param bankName a {@link java.lang.String} object.
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * <p>Getter for the field <code>bankAddress</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBankAddress() {
        return bankAddress;
    }

    /**
     * <p>Setter for the field <code>bankAddress</code>.</p>
     *
     * @param bankAddress a {@link java.lang.String} object.
     */
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    /**
     * <p>Getter for the field <code>bankCity</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBankCity() {
        return bankCity;
    }

    /**
     * <p>Setter for the field <code>bankCity</code>.</p>
     *
     * @param bankCity a {@link java.lang.String} object.
     */
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    /**
     * <p>Getter for the field <code>bankRegionCode</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBankRegionCode() {
        return bankRegionCode;
    }

    /**
     * <p>Setter for the field <code>bankRegionCode</code>.</p>
     *
     * @param bankRegionCode a {@link java.lang.String} object.
     */
    public void setBankRegionCode(String bankRegionCode) {
        this.bankRegionCode = bankRegionCode;
    }

    /**
     * <p>Getter for the field <code>bankPostalCode</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBankPostalCode() {
        return bankPostalCode;
    }

    /**
     * <p>Setter for the field <code>bankPostalCode</code>.</p>
     *
     * @param bankPostalCode a {@link java.lang.String} object.
     */
    public void setBankPostalCode(String bankPostalCode) {
        this.bankPostalCode = bankPostalCode;
    }

    /**
     * <p>findAll.</p>
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @return a {@link java.util.List} object.
     * @throws java.lang.Exception if any.
     */
    public static List<RecipientAccount> findAll(String recipient_id) throws Exception {
        return Configuration.gateway().recipientAccount.findAll(recipient_id);
    }

    /**
     * <p>find.</p>
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @param recipient_account_id a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.RecipientAccount} object.
     * @throws java.lang.Exception if any.
     */
    public static RecipientAccount find(String recipient_id, String recipient_account_id) throws Exception {
       return Configuration.gateway().recipientAccount.find(recipient_id, recipient_account_id);
    }

    /**
     * <p>create.</p>
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.RecipientAccount} object.
     * @throws java.lang.Exception if any.
     */
    public static RecipientAccount create(String recipient_id, String body) throws Exception {
       return Configuration.gateway().recipientAccount.create(recipient_id, body);
    }

    /**
     * <p>update.</p>
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @param recipient_account_id a {@link java.lang.String} object.
     * @param body a {@link java.lang.String} object.
     * @return a {@link com.trolley.trolley.RecipientAccount} object.
     * @throws java.lang.Exception if any.
     */
    public static RecipientAccount update(String recipient_id, String recipient_account_id, String body) throws Exception {
        return Configuration.gateway().recipientAccount.update(recipient_id, recipient_account_id, body);
    }

    /**
     * <p>delete.</p>
     *
     * @param recipient_id a {@link java.lang.String} object.
     * @param recipient_account_id a {@link java.lang.String} object.
     * @return a boolean.
     * @throws java.lang.Exception if any.
     */
    public static boolean delete(String recipient_id, String recipient_account_id) throws Exception {
        return Configuration.gateway().recipientAccount.delete(recipient_id, recipient_account_id);
    }

}
