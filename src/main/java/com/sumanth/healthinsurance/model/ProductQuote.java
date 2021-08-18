package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PRODUCT_QUOTE", schema = "INSURANCE_COMPANY", catalog = "")
public class ProductQuote {
    private String productQuoteId;
    private Double age;
    private Integer numOfPeopleOnPlan;
    private Double bmi;
    private Byte isSmoker;
    private Double charges;
    private String description;
    @JsonBackReference(value = "product-quote-region")
    private Region regionByRegionId;
    @JsonBackReference(value = "product-quote-product")
    private Product productByProductId;
    @JsonManagedReference(value = "quote-request-product-quote-product-quote")
    private Collection<QuoteRequestProductQuote> quoteRequestProductQuotesByProductQuoteId;

    @Id
    @Column(name = "product_quote_id")
    public String getProductQuoteId() {
        return productQuoteId;
    }

    public void setProductQuoteId(String productQuoteId) {
        this.productQuoteId = productQuoteId;
    }

    @Basic
    @Column(name = "age")
    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    @Basic
    @Column(name = "num_of_people_on_plan")
    public Integer getNumOfPeopleOnPlan() {
        return numOfPeopleOnPlan;
    }

    public void setNumOfPeopleOnPlan(Integer numOfPeopleOnPlan) {
        this.numOfPeopleOnPlan = numOfPeopleOnPlan;
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
    @Column(name = "charges")
    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductQuote that = (ProductQuote) o;

        if (productQuoteId != null ? !productQuoteId.equals(that.productQuoteId) : that.productQuoteId != null)
            return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (numOfPeopleOnPlan != null ? !numOfPeopleOnPlan.equals(that.numOfPeopleOnPlan) : that.numOfPeopleOnPlan != null)
            return false;
        if (bmi != null ? !bmi.equals(that.bmi) : that.bmi != null) return false;
        if (isSmoker != null ? !isSmoker.equals(that.isSmoker) : that.isSmoker != null) return false;
        if (charges != null ? !charges.equals(that.charges) : that.charges != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productQuoteId != null ? productQuoteId.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (numOfPeopleOnPlan != null ? numOfPeopleOnPlan.hashCode() : 0);
        result = 31 * result + (bmi != null ? bmi.hashCode() : 0);
        result = 31 * result + (isSmoker != null ? isSmoker.hashCode() : 0);
        result = 31 * result + (charges != null ? charges.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @OneToMany(mappedBy = "productQuoteByProductQuoteId")
    public Collection<QuoteRequestProductQuote> getQuoteRequestProductQuotesByProductQuoteId() {
        return quoteRequestProductQuotesByProductQuoteId;
    }

    public void setQuoteRequestProductQuotesByProductQuoteId(Collection<QuoteRequestProductQuote> quoteRequestProductQuotesByProductQuoteId) {
        this.quoteRequestProductQuotesByProductQuoteId = quoteRequestProductQuotesByProductQuoteId;
    }
}
