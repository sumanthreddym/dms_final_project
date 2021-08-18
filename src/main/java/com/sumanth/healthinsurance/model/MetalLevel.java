package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "METAL_LEVEL", schema = "INSURANCE_COMPANY", catalog = "")
public class MetalLevel {
    private String metalLevelId;
    private String metalLevelName;
    private String description;
    @JsonManagedReference(value = "product-metal-level")
    private Collection<Product> productsByMetalLevelId;
    @JsonManagedReference(value = "quote-request-metal-level")
    private Collection<QuoteRequest> quoteRequestsByMetalLevelId;

    @Id
    @Column(name = "metal_level_id")
    public String getMetalLevelId() {
        return metalLevelId;
    }

    public void setMetalLevelId(String metalLevelId) {
        this.metalLevelId = metalLevelId;
    }

    @Basic
    @Column(name = "metal_level_name")
    public String getMetalLevelName() {
        return metalLevelName;
    }

    public void setMetalLevelName(String metalLevelName) {
        this.metalLevelName = metalLevelName;
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

        MetalLevel that = (MetalLevel) o;

        if (metalLevelId != null ? !metalLevelId.equals(that.metalLevelId) : that.metalLevelId != null) return false;
        if (metalLevelName != null ? !metalLevelName.equals(that.metalLevelName) : that.metalLevelName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = metalLevelId != null ? metalLevelId.hashCode() : 0;
        result = 31 * result + (metalLevelName != null ? metalLevelName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "metalLevelByMetalLevelId")
    public Collection<Product> getProductsByMetalLevelId() {
        return productsByMetalLevelId;
    }

    public void setProductsByMetalLevelId(Collection<Product> productsByMetalLevelId) {
        this.productsByMetalLevelId = productsByMetalLevelId;
    }

    @OneToMany(mappedBy = "metalLevelByMetalLevelId")
    public Collection<QuoteRequest> getQuoteRequestsByMetalLevelId() {
        return quoteRequestsByMetalLevelId;
    }

    public void setQuoteRequestsByMetalLevelId(Collection<QuoteRequest> quoteRequestsByMetalLevelId) {
        this.quoteRequestsByMetalLevelId = quoteRequestsByMetalLevelId;
    }
}
