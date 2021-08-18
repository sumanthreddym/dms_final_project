package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "BILLING_ACCOUNT", schema = "INSURANCE_COMPANY")
public class BillingAccount {
    private String billingAccountId;
    private String name;
    private String name2;
    private String taxIdNumber;
    private Byte onlineBillingFlag;
    private String activityStatus;
    private Timestamp activityStatusDate;
    private String webAddress;
    private Byte isPayrollProcessed;
    private Timestamp billingAcctTypeDate;
    @JsonManagedReference(value = "account-billing-account-billing-account")
    private Collection<AccountBillingAccount> accountBillingAccountsByBillingAccountId;
    @JsonBackReference(value = "billing-account-address")
    private Address addressByAddressId;
    @JsonManagedReference(value = "invoice-billing-account")
    private Collection<Invoice> invoicesByBillingAccountId;

    @Id
    @Column(name = "billing_account_id")
    public String getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name2")
    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Basic
    @Column(name = "tax_id_number")
    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    @Basic
    @Column(name = "online_billing_flag")
    public Byte getOnlineBillingFlag() {
        return onlineBillingFlag;
    }

    public void setOnlineBillingFlag(Byte onlineBillingFlag) {
        this.onlineBillingFlag = onlineBillingFlag;
    }

    @Basic
    @Column(name = "activity_status")
    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    @Basic
    @Column(name = "activity_status_date")
    public Timestamp getActivityStatusDate() {
        return activityStatusDate;
    }

    public void setActivityStatusDate(Timestamp activityStatusDate) {
        this.activityStatusDate = activityStatusDate;
    }

    @Basic
    @Column(name = "web_address")
    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Basic
    @Column(name = "is_payroll_processed")
    public Byte getIsPayrollProcessed() {
        return isPayrollProcessed;
    }

    public void setIsPayrollProcessed(Byte isPayrollProcessed) {
        this.isPayrollProcessed = isPayrollProcessed;
    }

    @Basic
    @Column(name = "billing_acct_type_date")
    public Timestamp getBillingAcctTypeDate() {
        return billingAcctTypeDate;
    }

    public void setBillingAcctTypeDate(Timestamp billingAcctTypeDate) {
        this.billingAcctTypeDate = billingAcctTypeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingAccount that = (BillingAccount) o;

        if (billingAccountId != null ? !billingAccountId.equals(that.billingAccountId) : that.billingAccountId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (name2 != null ? !name2.equals(that.name2) : that.name2 != null) return false;
        if (taxIdNumber != null ? !taxIdNumber.equals(that.taxIdNumber) : that.taxIdNumber != null) return false;
        if (onlineBillingFlag != null ? !onlineBillingFlag.equals(that.onlineBillingFlag) : that.onlineBillingFlag != null)
            return false;
        if (activityStatus != null ? !activityStatus.equals(that.activityStatus) : that.activityStatus != null)
            return false;
        if (activityStatusDate != null ? !activityStatusDate.equals(that.activityStatusDate) : that.activityStatusDate != null)
            return false;
        if (webAddress != null ? !webAddress.equals(that.webAddress) : that.webAddress != null) return false;
        if (isPayrollProcessed != null ? !isPayrollProcessed.equals(that.isPayrollProcessed) : that.isPayrollProcessed != null)
            return false;
        if (billingAcctTypeDate != null ? !billingAcctTypeDate.equals(that.billingAcctTypeDate) : that.billingAcctTypeDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = billingAccountId != null ? billingAccountId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        result = 31 * result + (taxIdNumber != null ? taxIdNumber.hashCode() : 0);
        result = 31 * result + (onlineBillingFlag != null ? onlineBillingFlag.hashCode() : 0);
        result = 31 * result + (activityStatus != null ? activityStatus.hashCode() : 0);
        result = 31 * result + (activityStatusDate != null ? activityStatusDate.hashCode() : 0);
        result = 31 * result + (webAddress != null ? webAddress.hashCode() : 0);
        result = 31 * result + (isPayrollProcessed != null ? isPayrollProcessed.hashCode() : 0);
        result = 31 * result + (billingAcctTypeDate != null ? billingAcctTypeDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "billingAccountByBillingAccountId")
    public Collection<AccountBillingAccount> getAccountBillingAccountsByBillingAccountId() {
        return accountBillingAccountsByBillingAccountId;
    }

    public void setAccountBillingAccountsByBillingAccountId(Collection<AccountBillingAccount> accountBillingAccountsByBillingAccountId) {
        this.accountBillingAccountsByBillingAccountId = accountBillingAccountsByBillingAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "billingAccountByBillingAccountId")
    public Collection<Invoice> getInvoicesByBillingAccountId() {
        return invoicesByBillingAccountId;
    }

    public void setInvoicesByBillingAccountId(Collection<Invoice> invoicesByBillingAccountId) {
        this.invoicesByBillingAccountId = invoicesByBillingAccountId;
    }
}
