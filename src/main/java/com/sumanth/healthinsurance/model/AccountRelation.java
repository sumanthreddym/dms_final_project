package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNT_RELATION", schema = "INSURANCE_COMPANY")
public class AccountRelation {
    private String relationshipType;
    private Timestamp relationTypeDate;
    private String accountRelationId;
    @JsonBackReference(value = "account-relation-account")
    private Account accountByMasterAccountId;
    @JsonBackReference(value = "account-relation-0-account")
    private Account accountByRelatedAccountId;

    @Basic
    @Column(name = "relationship_type")
    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    @Basic
    @Column(name = "relation_type_date")
    public Timestamp getRelationTypeDate() {
        return relationTypeDate;
    }

    public void setRelationTypeDate(Timestamp relationTypeDate) {
        this.relationTypeDate = relationTypeDate;
    }

    @Id
    @Column(name = "account_relation_id")
    public String getAccountRelationId() {
        return accountRelationId;
    }

    public void setAccountRelationId(String accountRelationId) {
        this.accountRelationId = accountRelationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountRelation that = (AccountRelation) o;

        if (relationshipType != null ? !relationshipType.equals(that.relationshipType) : that.relationshipType != null)
            return false;
        if (relationTypeDate != null ? !relationTypeDate.equals(that.relationTypeDate) : that.relationTypeDate != null)
            return false;
        if (accountRelationId != null ? !accountRelationId.equals(that.accountRelationId) : that.accountRelationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = relationshipType != null ? relationshipType.hashCode() : 0;
        result = 31 * result + (relationTypeDate != null ? relationTypeDate.hashCode() : 0);
        result = 31 * result + (accountRelationId != null ? accountRelationId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "master_account_id", referencedColumnName = "account_id")
    public Account getAccountByMasterAccountId() {
        return accountByMasterAccountId;
    }

    public void setAccountByMasterAccountId(Account accountByMasterAccountId) {
        this.accountByMasterAccountId = accountByMasterAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "related_account_id", referencedColumnName = "account_id")
    public Account getAccountByRelatedAccountId() {
        return accountByRelatedAccountId;
    }

    public void setAccountByRelatedAccountId(Account accountByRelatedAccountId) {
        this.accountByRelatedAccountId = accountByRelatedAccountId;
    }
}
