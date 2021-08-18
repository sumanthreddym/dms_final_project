package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CUSTOMER_RELATION", schema = "INSURANCE_COMPANY", catalog = "")
public class CustomerRelation {
    private Timestamp startDate;
    private Timestamp endDate;
    private String relationship;
    private String customerRelationId;
    @JsonBackReference(value="customer-relation-customer")
    private Customer customerByCustomer1Ssn;
    @JsonBackReference(value="customer-relation-0-customer")
    private Customer customerByCustomer2Ssn;

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
    @Column(name = "relationship")
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Id
    @Column(name = "customer_relation_id")
    public String getCustomerRelationId() {
        return customerRelationId;
    }

    public void setCustomerRelationId(String customerRelationId) {
        this.customerRelationId = customerRelationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerRelation that = (CustomerRelation) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (relationship != null ? !relationship.equals(that.relationship) : that.relationship != null) return false;
        if (customerRelationId != null ? !customerRelationId.equals(that.customerRelationId) : that.customerRelationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        result = 31 * result + (customerRelationId != null ? customerRelationId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer1_ssn", referencedColumnName = "customer_ssn")
    public Customer getCustomerByCustomer1Ssn() {
        return customerByCustomer1Ssn;
    }

    public void setCustomerByCustomer1Ssn(Customer customerByCustomer1Ssn) {
        this.customerByCustomer1Ssn = customerByCustomer1Ssn;
    }

    @ManyToOne
    @JoinColumn(name = "customer2_ssn", referencedColumnName = "customer_ssn")
    public Customer getCustomerByCustomer2Ssn() {
        return customerByCustomer2Ssn;
    }

    public void setCustomerByCustomer2Ssn(Customer customerByCustomer2Ssn) {
        this.customerByCustomer2Ssn = customerByCustomer2Ssn;
    }
}
