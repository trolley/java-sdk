
package com.trolley.types.supporting;

public class USD
{
    private Boolean primary;
    private String amount;
    private String currency;
    private String type;
    private String accountNumber;
    private Boolean display;
    
    public Boolean getPrimary() {
        return this.primary;
    }
    
    public void setPrimary(final Boolean primary) {
        this.primary = primary;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(final String amount) {
        this.amount = amount;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(final String currency) {
        this.currency = currency;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public Boolean getDisplay() {
        return this.display;
    }
    
    public void setDisplay(final Boolean display) {
        this.display = display;
    }
}
