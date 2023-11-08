package com.trolley.types;

import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.trolley.types.supporting.Address;
import com.trolley.types.supporting.Compliance;
import com.trolley.types.supporting.GovernmentId;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipient
{
    private String id;
    private String routeType;
    private String routeMinimum;
    private String estimatedFees;
    private String referenceId;
    private String email;
    private String name;
    private String lastName;
    private String firstName;
    private String type;

    @Deprecated
    private String taxType;

    private String status;
    private String language;
    private ComplianceStatus complianceStatus;
    private String dob;
    private String passport;
    private String updatedAt;
    private String createdAt;
    private String gravatarUrl;

    @Deprecated
    private String governmentId;
    
    private List<GovernmentId> governmentIds;
    private String ssn;
    private String primaryCurrency;
    private String placeOfBirth;
    private List<String> tags;
    private String merchantId;
    private String payoutMethod;
    private List<String> contactEmails;

    @Deprecated
    public Object inactiveReasons;

    private Compliance compliance;
    private List<RecipientAccount> accounts;
    private Address address;
    private String taxForm;
    private String taxFormStatus;
    private String taxWithholdingPercentage;

    public static enum ComplianceStatus {
        REVIEW("review"),
        BLOCKED("blocked"),
        PENDING("pending"),
        VERIFIED("verified");

        private String key;

        ComplianceStatus(String key) {
            this.key = key;
        }

        @JsonCreator
        public static ComplianceStatus fromString(String key) {
            return key == null
                    ? null
                    : ComplianceStatus.valueOf(key.toUpperCase(Locale.US));
        }

        @JsonValue
        public String getKey() {
            return key;
        }

        public String toString(){
            return key.toLowerCase(Locale.US);
        }
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
    
    public ComplianceStatus getComplianceStatus() {
        return this.complianceStatus;
    }
    
    public void setComplianceStatus(final ComplianceStatus complianceStatus) {
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

    public List<GovernmentId> getGovernmentIds() {
        return governmentIds;
    }

    public void setGovernmentIds(List<GovernmentId> governmentIds) {
        this.governmentIds = governmentIds;
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
}
