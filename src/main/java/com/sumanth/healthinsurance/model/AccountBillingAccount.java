package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNT_BILLING_ACCOUNT", schema = "INSURANCE_COMPANY", catalog = "")
public class AccountBillingAccount {
    private Timestamp startDate;
    private Integer billingFrequency;
    private Integer nonBillableMonths;
    private Integer enrollmentPeriodLength;
    private String fsaClaimReimbursementMethod;
    private Byte isPaymentCard;
    private Byte isIfcaException;
    private String accountBillingAccountId;
    @JsonBackReference(value = "account-billing-account-account")
    private Account accountByAccountId;
    @JsonBackReference(value = "account-billing-account-billing-account")
    private BillingAccount billingAccountByBillingAccountId;

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "billing_frequency")
    public Integer getBillingFrequency() {
        return billingFrequency;
    }

    public void setBillingFrequency(Integer billingFrequency) {
        this.billingFrequency = billingFrequency;
    }

    @Basic
    @Column(name = "non_billable_months")
    public Integer getNonBillableMonths() {
        return nonBillableMonths;
    }

    public void setNonBillableMonths(Integer nonBillableMonths) {
        this.nonBillableMonths = nonBillableMonths;
    }

    @Basic
    @Column(name = "enrollment_period_length")
    public Integer getEnrollmentPeriodLength() {
        return enrollmentPeriodLength;
    }

    public void setEnrollmentPeriodLength(Integer enrollmentPeriodLength) {
        this.enrollmentPeriodLength = enrollmentPeriodLength;
    }

    @Basic
    @Column(name = "fsa_claim_reimbursement_method")
    public String getFsaClaimReimbursementMethod() {
        return fsaClaimReimbursementMethod;
    }

    public void setFsaClaimReimbursementMethod(String fsaClaimReimbursementMethod) {
        this.fsaClaimReimbursementMethod = fsaClaimReimbursementMethod;
    }

    @Basic
    @Column(name = "is_payment_card")
    public Byte getIsPaymentCard() {
        return isPaymentCard;
    }

    public void setIsPaymentCard(Byte isPaymentCard) {
        this.isPaymentCard = isPaymentCard;
    }

    @Basic
    @Column(name = "is_ifca_exception")
    public Byte getIsIfcaException() {
        return isIfcaException;
    }

    public void setIsIfcaException(Byte isIfcaException) {
        this.isIfcaException = isIfcaException;
    }

    @Id
    @Column(name = "account_billing_account_id")
    public String getAccountBillingAccountId() {
        return accountBillingAccountId;
    }

    public void setAccountBillingAccountId(String accountBillingAccountId) {
        this.accountBillingAccountId = accountBillingAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountBillingAccount that = (AccountBillingAccount) o;


        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (billingFrequency != null ? !billingFrequency.equals(that.billingFrequency) : that.billingFrequency != null)
            return false;
        if (nonBillableMonths != null ? !nonBillableMonths.equals(that.nonBillableMonths) : that.nonBillableMonths != null)
            return false;
        if (enrollmentPeriodLength != null ? !enrollmentPeriodLength.equals(that.enrollmentPeriodLength) : that.enrollmentPeriodLength != null)
            return false;
        if (fsaClaimReimbursementMethod != null ? !fsaClaimReimbursementMethod.equals(that.fsaClaimReimbursementMethod) : that.fsaClaimReimbursementMethod != null)
            return false;
        if (isPaymentCard != null ? !isPaymentCard.equals(that.isPaymentCard) : that.isPaymentCard != null)
            return false;
        if (isIfcaException != null ? !isIfcaException.equals(that.isIfcaException) : that.isIfcaException != null)
            return false;
        if (accountBillingAccountId != null ? !accountBillingAccountId.equals(that.accountBillingAccountId) : that.accountBillingAccountId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (billingFrequency != null ? billingFrequency.hashCode() : 0);
        result = 31 * result + (nonBillableMonths != null ? nonBillableMonths.hashCode() : 0);
        result = 31 * result + (enrollmentPeriodLength != null ? enrollmentPeriodLength.hashCode() : 0);
        result = 31 * result + (fsaClaimReimbursementMethod != null ? fsaClaimReimbursementMethod.hashCode() : 0);
        result = 31 * result + (isPaymentCard != null ? isPaymentCard.hashCode() : 0);
        result = 31 * result + (isIfcaException != null ? isIfcaException.hashCode() : 0);
        result = 31 * result + (accountBillingAccountId != null ? accountBillingAccountId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "billing_account_id", referencedColumnName = "billing_account_id")
    public BillingAccount getBillingAccountByBillingAccountId() {
        return billingAccountByBillingAccountId;
    }

    public void setBillingAccountByBillingAccountId(BillingAccount billingAccountByBillingAccountId) {
        this.billingAccountByBillingAccountId = billingAccountByBillingAccountId;
    }
}
