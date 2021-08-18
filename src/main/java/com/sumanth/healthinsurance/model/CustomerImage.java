package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CUSTOMER_IMAGE", schema = "INSURANCE_COMPANY", catalog = "")
public class CustomerImage {
    private String documentId;
    private String imageType;
    private String imageFileLocation;
    private Timestamp dateReceived;
    @JsonBackReference(value="customer-image-customer")
    private Customer customerByCustomerSsn;

    @Id
    @Column(name = "document_id")
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @Basic
    @Column(name = "image_type")
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Basic
    @Column(name = "image_file_location")
    public String getImageFileLocation() {
        return imageFileLocation;
    }

    public void setImageFileLocation(String imageFileLocation) {
        this.imageFileLocation = imageFileLocation;
    }

    @Basic
    @Column(name = "date_received")
    public Timestamp getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Timestamp dateReceived) {
        this.dateReceived = dateReceived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerImage that = (CustomerImage) o;

        if (documentId != null ? !documentId.equals(that.documentId) : that.documentId != null) return false;
        if (imageType != null ? !imageType.equals(that.imageType) : that.imageType != null) return false;
        if (imageFileLocation != null ? !imageFileLocation.equals(that.imageFileLocation) : that.imageFileLocation != null)
            return false;
        if (dateReceived != null ? !dateReceived.equals(that.dateReceived) : that.dateReceived != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = documentId != null ? documentId.hashCode() : 0;
        result = 31 * result + (imageType != null ? imageType.hashCode() : 0);
        result = 31 * result + (imageFileLocation != null ? imageFileLocation.hashCode() : 0);
        result = 31 * result + (dateReceived != null ? dateReceived.hashCode() : 0);
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
}
