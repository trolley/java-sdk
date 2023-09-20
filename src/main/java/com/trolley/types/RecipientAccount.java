
package com.trolley.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trolley.Configuration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipientAccount
{
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
    
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getDisabledAt() {
        return this.disabledAt;
    }
    
    public void setDisabledAt(final String disabledAt) {
        this.disabledAt = disabledAt;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getRecipientId() {
        return this.recipientId;
    }
    
    public void setRecipientId(final String recipientId) {
        this.recipientId = recipientId;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public Boolean getPrimary() {
        return this.primary;
    }
    
    public void setPrimary(final Boolean primary) {
        this.primary = primary;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getRecipientAccountId() {
        return this.recipientAccountId;
    }
    
    public void setRecipientAccountId(final String recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }
    
    public String getRouteType() {
        return this.routeType;
    }
    
    public void setRouteType(final String routeType) {
        this.routeType = routeType;
    }
    
    public String getRecipientFees() {
        return this.recipientFees;
    }
    
    public void setRecipientFees(final String recipientFees) {
        this.recipientFees = recipientFees;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(final String country) {
        this.country = country;
    }
    
    public String getIban() {
        return this.iban;
    }
    
    public void setIban(final String iban) {
        this.iban = iban;
    }
    
    public String getAccountNum() {
        return this.accountNum;
    }
    
    public void setAccountNum(final String accountNum) {
        this.accountNum = accountNum;
    }
    
    public String getAccountHolderName() {
        return this.accountHolderName;
    }
    
    public void setAccountHolderName(final String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    
    public String getSwiftBic() {
        return this.swiftBic;
    }
    
    public void setSwiftBic(final String swiftBic) {
        this.swiftBic = swiftBic;
    }
    
    public String getBranchId() {
        return this.branchId;
    }
    
    public void setBranchId(final String branchId) {
        this.branchId = branchId;
    }
    
    public String getBankId() {
        return this.bankId;
    }
    
    public void setBankId(final String bankId) {
        this.bankId = bankId;
    }
    
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }
    
    public String getBankAddress() {
        return this.bankAddress;
    }
    
    public void setBankAddress(final String bankAddress) {
        this.bankAddress = bankAddress;
    }
    
    public String getBankCity() {
        return this.bankCity;
    }
    
    public void setBankCity(final String bankCity) {
        this.bankCity = bankCity;
    }
    
    public String getBankRegionCode() {
        return this.bankRegionCode;
    }
    
    public void setBankRegionCode(final String bankRegionCode) {
        this.bankRegionCode = bankRegionCode;
    }
    
    public String getBankPostalCode() {
        return this.bankPostalCode;
    }
    
    public void setBankPostalCode(final String bankPostalCode) {
        this.bankPostalCode = bankPostalCode;
    }
    
    public static List<RecipientAccount> findAll(final String recipient_id) throws Exception {
        return Configuration.gateway().recipientAccount.findAll(recipient_id);
    }
    
    public static RecipientAccount find(final String recipient_id, final String recipient_account_id) throws Exception {
        return Configuration.gateway().recipientAccount.find(recipient_id, recipient_account_id);
    }
    
    public static RecipientAccount create(final String recipient_id, final String body) throws Exception {
        return Configuration.gateway().recipientAccount.create(recipient_id, body);
    }
    
    public static RecipientAccount update(final String recipient_id, final String recipient_account_id, final String body) throws Exception {
        return Configuration.gateway().recipientAccount.update(recipient_id, recipient_account_id, body);
    }
    
    public static boolean delete(final String recipient_id, final String recipient_account_id) throws Exception {
        return Configuration.gateway().recipientAccount.delete(recipient_id, recipient_account_id);
    }
}
