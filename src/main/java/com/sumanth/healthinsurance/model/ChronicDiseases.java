package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CHRONIC_DISEASES", schema = "INSURANCE_COMPANY", catalog = "")
public class ChronicDiseases {
    private String chronicDiseaseId;
    private String name;
    private String typicalAge;
    private String description;
    private String medication;
    @JsonManagedReference(value="chronic-disease-customer-chronic-diseases")
    private Collection<ChronicDiseaseCustomer> chronicDiseaseCustomersByChronicDiseaseId;

    @Id
    @Column(name = "chronic_disease_id")
    public String getChronicDiseaseId() {
        return chronicDiseaseId;
    }

    public void setChronicDiseaseId(String chronicDiseaseId) {
        this.chronicDiseaseId = chronicDiseaseId;
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
    @Column(name = "typical_age")
    public String getTypicalAge() {
        return typicalAge;
    }

    public void setTypicalAge(String typicalAge) {
        this.typicalAge = typicalAge;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "medication")
    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChronicDiseases that = (ChronicDiseases) o;

        if (chronicDiseaseId != null ? !chronicDiseaseId.equals(that.chronicDiseaseId) : that.chronicDiseaseId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (typicalAge != null ? !typicalAge.equals(that.typicalAge) : that.typicalAge != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (medication != null ? !medication.equals(that.medication) : that.medication != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chronicDiseaseId != null ? chronicDiseaseId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typicalAge != null ? typicalAge.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (medication != null ? medication.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "chronicDiseasesByChronicDiseaseId")
    public Collection<ChronicDiseaseCustomer> getChronicDiseaseCustomersByChronicDiseaseId() {
        return chronicDiseaseCustomersByChronicDiseaseId;
    }

    public void setChronicDiseaseCustomersByChronicDiseaseId(Collection<ChronicDiseaseCustomer> chronicDiseaseCustomersByChronicDiseaseId) {
        this.chronicDiseaseCustomersByChronicDiseaseId = chronicDiseaseCustomersByChronicDiseaseId;
    }
}
