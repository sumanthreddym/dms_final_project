package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ASSOCIATE_ROLE", schema = "INSURANCE_COMPANY", catalog = "")
public class AssociateRole {
    private Timestamp endDate;
    private Timestamp startDate;
    private String associateRoleId;
    @JsonBackReference(value = "associate-role-associate")
    private Associate associateByAssociateSsn;
    @JsonBackReference(value = "associate-role-role")
    private Role roleByRoleId;

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Id
    @Column(name = "associate_role_id")
    public String getAssociateRoleId() {
        return associateRoleId;
    }

    public void setAssociateRoleId(String associateRoleId) {
        this.associateRoleId = associateRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssociateRole that = (AssociateRole) o;

       if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (associateRoleId != null ? !associateRoleId.equals(that.associateRoleId) : that.associateRoleId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = endDate != null ? endDate.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (associateRoleId != null ? associateRoleId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "associate_ssn", referencedColumnName = "associate_ssn")
    public Associate getAssociateByAssociateSsn() {
        return associateByAssociateSsn;
    }

    public void setAssociateByAssociateSsn(Associate associateByAssociateSsn) {
        this.associateByAssociateSsn = associateByAssociateSsn;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
