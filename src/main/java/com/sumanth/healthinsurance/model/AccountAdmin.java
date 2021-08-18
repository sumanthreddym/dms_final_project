package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNT_ADMIN", schema = "INSURANCE_COMPANY", catalog = "")
public class AccountAdmin {
    private String accountAdminId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Byte isActive;
    @JsonBackReference(value="account-admin-account")
    private Account accountByAccountId;
    @JsonBackReference(value="account-admin-associate")
    private Associate associateByAssociateSsn;

    @Id
    @Column(name = "account_admin_id")
    public String getAccountAdminId() {
        return accountAdminId;
    }

    public void setAccountAdminId(String accountAdminId) {
        this.accountAdminId = accountAdminId;
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

        AccountAdmin that = (AccountAdmin) o;

        if (accountAdminId != null ? !accountAdminId.equals(that.accountAdminId) : that.accountAdminId != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountAdminId != null ? accountAdminId.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
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
    @JoinColumn(name = "associate_ssn", referencedColumnName = "associate_ssn")
    public Associate getAssociateByAssociateSsn() {
        return associateByAssociateSsn;
    }

    public void setAssociateByAssociateSsn(Associate associateByAssociateSsn) {
        this.associateByAssociateSsn = associateByAssociateSsn;
    }
}
