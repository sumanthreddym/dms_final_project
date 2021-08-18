package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNT_MEMBER", schema = "INSURANCE_COMPANY", catalog = "")
public class AccountMember {
    private Double fsaContributionAmount;
    private String custBAcctDepartmentName;
    private Timestamp startDate;
    private Timestamp endDate;
    private String accountMemberId;
    @JsonBackReference(value="account-member-customer")
    private Customer customerByCustomerSsn;
    @JsonBackReference(value="account-member-account")
    private Account accountByAccountId;

    @Basic
    @Column(name = "fsa_contribution_amount")
    public Double getFsaContributionAmount() {
        return fsaContributionAmount;
    }

    public void setFsaContributionAmount(Double fsaContributionAmount) {
        this.fsaContributionAmount = fsaContributionAmount;
    }

    @Basic
    @Column(name = "cust_b_acct_department_name")
    public String getCustBAcctDepartmentName() {
        return custBAcctDepartmentName;
    }

    public void setCustBAcctDepartmentName(String custBAcctDepartmentName) {
        this.custBAcctDepartmentName = custBAcctDepartmentName;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Id
    @Column(name = "account_member_id")
    public String getAccountMemberId() {
        return accountMemberId;
    }

    public void setAccountMemberId(String accountMemberId) {
        this.accountMemberId = accountMemberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountMember that = (AccountMember) o;

        if (fsaContributionAmount != null ? !fsaContributionAmount.equals(that.fsaContributionAmount) : that.fsaContributionAmount != null)
            return false;
        if (custBAcctDepartmentName != null ? !custBAcctDepartmentName.equals(that.custBAcctDepartmentName) : that.custBAcctDepartmentName != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (accountMemberId != null ? !accountMemberId.equals(that.accountMemberId) : that.accountMemberId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fsaContributionAmount != null ? fsaContributionAmount.hashCode() : 0;
        result = 31 * result + (custBAcctDepartmentName != null ? custBAcctDepartmentName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (accountMemberId != null ? accountMemberId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_ssn", referencedColumnName = "customer_ssn")
    public Customer getCustomerByCustomerSsn() {
        return customerByCustomerSsn;
    }

    public void setCustomerByCustomerSsn(Customer customerByCustomerSsn) {
        this.customerByCustomerSsn = customerByCustomerSsn;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }
}
