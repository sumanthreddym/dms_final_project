package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "QUOTE_REQUEST", schema = "INSURANCE_COMPANY", catalog = "")
public class QuoteRequest {
    private String quoteRequestId;
    private Integer numberOfPeopleOnPlan;
    private Double bmi;
    private Byte isSmoker;
    private Double maxPrice;
    private Byte isSaleComplete;
    @JsonBackReference(value="quote-request-customer")
    private Customer customerByCustomerSsn;
    @JsonBackReference(value="quote-request-associate")
    private Associate associateByAssociateSsn;
    @JsonBackReference(value="quote-request-region")
    private Region regionByRegionId;
    @JsonBackReference(value="quote-request-metal-level")
    private MetalLevel metalLevelByMetalLevelId;
    @JsonManagedReference(value="quote-request-product-quote-quote-request")
    private Collection<QuoteRequestProductQuote> quoteRequestProductQuotesByQuoteRequestId;

    @Id
    @Column(name = "quote_request_id")
    public String getQuoteRequestId() {
        return quoteRequestId;
    }

    public void setQuoteRequestId(String quoteRequestId) {
        this.quoteRequestId = quoteRequestId;
    }

    @Basic
    @Column(name = "number_of_people_on_plan")
    public Integer getNumberOfPeopleOnPlan() {
        return numberOfPeopleOnPlan;
    }

    public void setNumberOfPeopleOnPlan(Integer numberOfPeopleOnPlan) {
        this.numberOfPeopleOnPlan = numberOfPeopleOnPlan;
    }

    @Basic
    @Column(name = "bmi")
    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    @Basic
    @Column(name = "is_smoker")
    public Byte getIsSmoker() {
        return isSmoker;
    }

    public void setIsSmoker(Byte isSmoker) {
        this.isSmoker = isSmoker;
    }

    @Basic
    @Column(name = "max_price")
    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Basic
    @Column(name = "is_sale_complete")
    public Byte getIsSaleComplete() {
        return isSaleComplete;
    }

    public void setIsSaleComplete(Byte isSaleComplete) {
        this.isSaleComplete = isSaleComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteRequest that = (QuoteRequest) o;

        if (quoteRequestId != null ? !quoteRequestId.equals(that.quoteRequestId) : that.quoteRequestId != null)
            return false;
        if (numberOfPeopleOnPlan != null ? !numberOfPeopleOnPlan.equals(that.numberOfPeopleOnPlan) : that.numberOfPeopleOnPlan != null)
            return false;
        if (bmi != null ? !bmi.equals(that.bmi) : that.bmi != null) return false;
        if (isSmoker != null ? !isSmoker.equals(that.isSmoker) : that.isSmoker != null) return false;
        if (maxPrice != null ? !maxPrice.equals(that.maxPrice) : that.maxPrice != null) return false;
        if (isSaleComplete != null ? !isSaleComplete.equals(that.isSaleComplete) : that.isSaleComplete != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quoteRequestId != null ? quoteRequestId.hashCode() : 0;
        result = 31 * result + (numberOfPeopleOnPlan != null ? numberOfPeopleOnPlan.hashCode() : 0);
        result = 31 * result + (bmi != null ? bmi.hashCode() : 0);
        result = 31 * result + (isSmoker != null ? isSmoker.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (isSaleComplete != null ? isSaleComplete.hashCode() : 0);
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
    @JoinColumn(name = "associate_ssn", referencedColumnName = "associate_ssn")
    public Associate getAssociateByAssociateSsn() {
        return associateByAssociateSsn;
    }

    public void setAssociateByAssociateSsn(Associate associateByAssociateSsn) {
        this.associateByAssociateSsn = associateByAssociateSsn;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    public Region getRegionByRegionId() {
        return regionByRegionId;
    }

    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }

    @ManyToOne
    @JoinColumn(name = "metal_level_id", referencedColumnName = "metal_level_id")
    public MetalLevel getMetalLevelByMetalLevelId() {
        return metalLevelByMetalLevelId;
    }

    public void setMetalLevelByMetalLevelId(MetalLevel metalLevelByMetalLevelId) {
        this.metalLevelByMetalLevelId = metalLevelByMetalLevelId;
    }

    @OneToMany(mappedBy = "quoteRequestByQuoteRequestId")
    public Collection<QuoteRequestProductQuote> getQuoteRequestProductQuotesByQuoteRequestId() {
        return quoteRequestProductQuotesByQuoteRequestId;
    }

    public void setQuoteRequestProductQuotesByQuoteRequestId(Collection<QuoteRequestProductQuote> quoteRequestProductQuotesByQuoteRequestId) {
        this.quoteRequestProductQuotesByQuoteRequestId = quoteRequestProductQuotesByQuoteRequestId;
    }
}
