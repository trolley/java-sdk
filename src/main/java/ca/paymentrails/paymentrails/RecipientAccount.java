package ca.paymentrails.paymentrails;

import java.util.List;

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

    public String getEmailAddress(){
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }


    public String getDisabledAt(){
        return disabledAt;
    }
    public void setDisabledAt(String disabledAt){
        this.disabledAt = disabledAt;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getRecipientId(){
        return recipientId;
    }
    public void setRecipientId(String recipientId){
        this.recipientId = recipientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(String recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getRecipientFees() {
        return recipientFees;
    }

    public void setRecipientFees(String recipientFees) {
        this.recipientFees = recipientFees;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getSwiftBic() {
        return swiftBic;
    }

    public void setSwiftBic(String swiftBic) {
        this.swiftBic = swiftBic;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankRegionCode() {
        return bankRegionCode;
    }

    public void setBankRegionCode(String bankRegionCode) {
        this.bankRegionCode = bankRegionCode;
    }

    public String getBankPostalCode() {
        return bankPostalCode;
    }

    public void setBankPostalCode(String bankPostalCode) {
        this.bankPostalCode = bankPostalCode;
    }

    public static List<RecipientAccount> findAll(String recipient_id) throws Exception {
        return Configuration.gateway().recipientAccount.findAll(recipient_id);
    }

    public static RecipientAccount find(String recipient_id, String recipient_account_id) throws Exception {
       return Configuration.gateway().recipientAccount.find(recipient_id, recipient_account_id);
    }

    public static RecipientAccount create(String recipient_id, String body) throws Exception {
       return Configuration.gateway().recipientAccount.create(recipient_id, body);
    }

    public static RecipientAccount update(String recipient_id, String recipient_account_id, String body) throws Exception {
        return Configuration.gateway().recipientAccount.update(recipient_id, recipient_account_id, body);
    }

    public static boolean delete(String recipient_id, String recipient_account_id) throws Exception {
        return Configuration.gateway().recipientAccount.delete(recipient_id, recipient_account_id);
    }

}