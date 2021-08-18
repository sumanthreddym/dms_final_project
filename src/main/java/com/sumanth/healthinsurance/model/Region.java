package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {
    private String regionId;
    private String regionName;
    @JsonManagedReference(value = "county-region")
    private Collection<County> countiesByRegionId;
    @JsonManagedReference(value = "product-quote-region")
    private Collection<ProductQuote> productQuotesByRegionId;
    @JsonManagedReference(value = "quote-request-region")
    private Collection<QuoteRequest> quoteRequestsByRegionId;

    @Id
    @Column(name = "region_id")
    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (regionId != null ? !regionId.equals(region.regionId) : region.regionId != null) return false;
        if (regionName != null ? !regionName.equals(region.regionName) : region.regionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionId != null ? regionId.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionByRegionId")
    public Collection<County> getCountiesByRegionId() {
        return countiesByRegionId;
    }

    public void setCountiesByRegionId(Collection<County> countiesByRegionId) {
        this.countiesByRegionId = countiesByRegionId;
    }

    @OneToMany(mappedBy = "regionByRegionId")
    public Collection<ProductQuote> getProductQuotesByRegionId() {
        return productQuotesByRegionId;
    }

    public void setProductQuotesByRegionId(Collection<ProductQuote> productQuotesByRegionId) {
        this.productQuotesByRegionId = productQuotesByRegionId;
    }

    @OneToMany(mappedBy = "regionByRegionId")
    public Collection<QuoteRequest> getQuoteRequestsByRegionId() {
        return quoteRequestsByRegionId;
    }

    public void setQuoteRequestsByRegionId(Collection<QuoteRequest> quoteRequestsByRegionId) {
        this.quoteRequestsByRegionId = quoteRequestsByRegionId;
    }
}
