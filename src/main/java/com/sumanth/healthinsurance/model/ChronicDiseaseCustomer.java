package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "CHRONIC_DISEASE_CUSTOMER", schema = "INSURANCE_COMPANY", catalog = "")
public class ChronicDiseaseCustomer {
    private Byte isPredicted;
    private String chronicDiseaseCustomerId;
    @JsonBackReference(value="chronic-disease-customer-customer")
    private Customer customerByCustomerSsn;
    @JsonBackReference(value="chronic-disease-customer-chronic-diseases")
    private ChronicDiseases chronicDiseasesByChronicDiseaseId;

    @Basic
    @Column(name = "is_predicted")
    public Byte getIsPredicted() {
        return isPredicted;
    }

    public void setIsPredicted(Byte isPredicted) {
        this.isPredicted = isPredicted;
    }

    @Id
    @Column(name = "chronic_disease_customer_id")
    public String getChronicDiseaseCustomerId() {
        return chronicDiseaseCustomerId;
    }

    public void setChronicDiseaseCustomerId(String chronicDiseaseCustomerId) {
        this.chronicDiseaseCustomerId = chronicDiseaseCustomerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChronicDiseaseCustomer that = (ChronicDiseaseCustomer) o;

        if (isPredicted != null ? !isPredicted.equals(that.isPredicted) : that.isPredicted != null) return false;
        if (chronicDiseaseCustomerId != null ? !chronicDiseaseCustomerId.equals(that.chronicDiseaseCustomerId) : that.chronicDiseaseCustomerId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isPredicted != null ? isPredicted.hashCode() : 0;
        result = 31 * result + (chronicDiseaseCustomerId != null ? chronicDiseaseCustomerId.hashCode() : 0);
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
    @JoinColumn(name = "chronic_disease_id", referencedColumnName = "chronic_disease_id")
    public ChronicDiseases getChronicDiseasesByChronicDiseaseId() {
        return chronicDiseasesByChronicDiseaseId;
    }

    public void setChronicDiseasesByChronicDiseaseId(ChronicDiseases chronicDiseasesByChronicDiseaseId) {
        this.chronicDiseasesByChronicDiseaseId = chronicDiseasesByChronicDiseaseId;
    }
}
