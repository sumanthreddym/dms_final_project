package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Account {
    private String accountId;
    private String name;
    private String taxIdNumber;
    private String emailAddress;
    private String phoneNumber;
    private Timestamp accountEstablishedDate;
    private Timestamp accountStartDate;
    private Timestamp accountEndDate;
    private Byte isActive;
    @JsonManagedReference(value="account-admin-account")
    private Collection<AccountAdmin> accountAdminsByAccountId;
    @JsonManagedReference(value="account-billing-account-account")
    private Collection<AccountBillingAccount> accountBillingAccountsByAccountId;
    @JsonManagedReference(value="account-member-account")
    private Collection<AccountMember> accountMembersByAccountId;
    @JsonManagedReference(value="account-product-account")
    private Collection<AccountProduct> accountProductsByAccountId;
    @JsonManagedReference(value="account-relation-account")
    private Collection<AccountRelation> accountRelationsByAccountId;
    @JsonManagedReference(value="account-relation-0-account")
    private Collection<AccountRelation> accountRelationsByAccountId_0;

    @Id
    @Column(name = "account_id")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
    @Column(name = "tax_id_number")
    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    @Basic
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "account_established_date")
    public Timestamp getAccountEstablishedDate() {
        return accountEstablishedDate;
    }

    public void setAccountEstablishedDate(Timestamp accountEstablishedDate) {
        this.accountEstablishedDate = accountEstablishedDate;
    }

    @Basic
    @Column(name = "account_start_date")
    public Timestamp getAccountStartDate() {
        return accountStartDate;
    }

    public void setAccountStartDate(Timestamp accountStartDate) {
        this.accountStartDate = accountStartDate;
    }

    @Basic
    @Column(name = "account_end_date")
    public Timestamp getAccountEndDate() {
        return accountEndDate;
    }

    public void setAccountEndDate(Timestamp accountEndDate) {
        this.accountEndDate = accountEndDate;
    }

    @Basic
    @Column(name = "is_active")
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != null ? !accountId.equals(account.accountId) : account.accountId != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (taxIdNumber != null ? !taxIdNumber.equals(account.taxIdNumber) : account.taxIdNumber != null) return false;
        if (emailAddress != null ? !emailAddress.equals(account.emailAddress) : account.emailAddress != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(account.phoneNumber) : account.phoneNumber != null) return false;
        if (accountEstablishedDate != null ? !accountEstablishedDate.equals(account.accountEstablishedDate) : account.accountEstablishedDate != null)
            return false;
        if (accountStartDate != null ? !accountStartDate.equals(account.accountStartDate) : account.accountStartDate != null)
            return false;
        if (accountEndDate != null ? !accountEndDate.equals(account.accountEndDate) : account.accountEndDate != null)
            return false;
        if (isActive != null ? !isActive.equals(account.isActive) : account.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (taxIdNumber != null ? taxIdNumber.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (accountEstablishedDate != null ? accountEstablishedDate.hashCode() : 0);
        result = 31 * result + (accountStartDate != null ? accountStartDate.hashCode() : 0);
        result = 31 * result + (accountEndDate != null ? accountEndDate.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<AccountAdmin> getAccountAdminsByAccountId() {
        return accountAdminsByAccountId;
    }

    public void setAccountAdminsByAccountId(Collection<AccountAdmin> accountAdminsByAccountId) {
        this.accountAdminsByAccountId = accountAdminsByAccountId;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<AccountBillingAccount> getAccountBillingAccountsByAccountId() {
        return accountBillingAccountsByAccountId;
    }

    public void setAccountBillingAccountsByAccountId(Collection<AccountBillingAccount> accountBillingAccountsByAccountId) {
        this.accountBillingAccountsByAccountId = accountBillingAccountsByAccountId;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<AccountMember> getAccountMembersByAccountId() {
        return accountMembersByAccountId;
    }

    public void setAccountMembersByAccountId(Collection<AccountMember> accountMembersByAccountId) {
        this.accountMembersByAccountId = accountMembersByAccountId;
    }

    @OneToMany(mappedBy = "accountByAccountId")
    public Collection<AccountProduct> getAccountProductsByAccountId() {
        return accountProductsByAccountId;
    }

    public void setAccountProductsByAccountId(Collection<AccountProduct> accountProductsByAccountId) {
        this.accountProductsByAccountId = accountProductsByAccountId;
    }

    @OneToMany(mappedBy = "accountByMasterAccountId")
    public Collection<AccountRelation> getAccountRelationsByAccountId() {
        return accountRelationsByAccountId;
    }

    public void setAccountRelationsByAccountId(Collection<AccountRelation> accountRelationsByAccountId) {
        this.accountRelationsByAccountId = accountRelationsByAccountId;
    }

    @OneToMany(mappedBy = "accountByRelatedAccountId")
    public Collection<AccountRelation> getAccountRelationsByAccountId_0() {
        return accountRelationsByAccountId_0;
    }

    public void setAccountRelationsByAccountId_0(Collection<AccountRelation> accountRelationsByAccountId_0) {
        this.accountRelationsByAccountId_0 = accountRelationsByAccountId_0;
    }
}
