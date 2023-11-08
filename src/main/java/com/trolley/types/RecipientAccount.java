package com.trolley.types;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipientAccount
{
    private String type;
    
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean primary;

    private String currency;
    private String id;
    private String recipientId;
    private String recipientAccountId;
    private String routeType;
    private String recipientFees;
    private String country;
    private String iban;
    private String accountNum;
    private String accountHolderName;
    private String swiftBic;
    private String branchId;
    private String bankId;
    private String bankName;
    private String bankAddress;
    private String bankCity;
    private String bankRegionCode;
    private String bankPostalCode;
    private String emailAddress;
    private String status;
    private String disabledAt;
    
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
    
    public boolean getPrimary() {
        return this.primary;
    }
    
    public void setPrimary(final boolean primary) {
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
    
}
