package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    private String productId;
    private String planName;
    private String lineOfBusiness;
    private String description;
    private String ratingArea;
    private Byte isAdultChildOnly;
    private String networkUrl;
    private String planBrochureUrl;
    private String benefitsSumaryUrl;
    private String drugFormulaUrl;
    private Byte isDentalIncluded;
    @JsonManagedReference(value = "account-product-product")
    private Collection<AccountProduct> accountProductsByProductId;
    @JsonBackReference(value = "product-metal-level")
    private MetalLevel metalLevelByMetalLevelId;
    @JsonBackReference(value = "product-company")
    private Company companyByCompanyCode;
    @JsonManagedReference(value = "product-quote-product")
    private Collection<ProductQuote> productQuotesByProductId;

    @Id
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "plan_name")
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Basic
    @Column(name = "line_of_business")
    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
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
    @Column(name = "rating_area")
    public String getRatingArea() {
        return ratingArea;
    }

    public void setRatingArea(String ratingArea) {
        this.ratingArea = ratingArea;
    }

    @Basic
    @Column(name = "is_adult_child_only")
    public Byte getIsAdultChildOnly() {
        return isAdultChildOnly;
    }

    public void setIsAdultChildOnly(Byte isAdultChildOnly) {
        this.isAdultChildOnly = isAdultChildOnly;
    }

    @Basic
    @Column(name = "network_url")
    public String getNetworkUrl() {
        return networkUrl;
    }

    public void setNetworkUrl(String networkUrl) {
        this.networkUrl = networkUrl;
    }

    @Basic
    @Column(name = "plan_brochure_url")
    public String getPlanBrochureUrl() {
        return planBrochureUrl;
    }

    public void setPlanBrochureUrl(String planBrochureUrl) {
        this.planBrochureUrl = planBrochureUrl;
    }

    @Basic
    @Column(name = "benefits_sumary_url")
    public String getBenefitsSumaryUrl() {
        return benefitsSumaryUrl;
    }

    public void setBenefitsSumaryUrl(String benefitsSumaryUrl) {
        this.benefitsSumaryUrl = benefitsSumaryUrl;
    }

    @Basic
    @Column(name = "drug_formula_url")
    public String getDrugFormulaUrl() {
        return drugFormulaUrl;
    }

    public void setDrugFormulaUrl(String drugFormulaUrl) {
        this.drugFormulaUrl = drugFormulaUrl;
    }

    @Basic
    @Column(name = "is_dental_included")
    public Byte getIsDentalIncluded() {
        return isDentalIncluded;
    }

    public void setIsDentalIncluded(Byte isDentalIncluded) {
        this.isDentalIncluded = isDentalIncluded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (planName != null ? !planName.equals(product.planName) : product.planName != null) return false;
        if (lineOfBusiness != null ? !lineOfBusiness.equals(product.lineOfBusiness) : product.lineOfBusiness != null)
            return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (ratingArea != null ? !ratingArea.equals(product.ratingArea) : product.ratingArea != null) return false;
        if (isAdultChildOnly != null ? !isAdultChildOnly.equals(product.isAdultChildOnly) : product.isAdultChildOnly != null)
            return false;
        if (networkUrl != null ? !networkUrl.equals(product.networkUrl) : product.networkUrl != null) return false;
        if (planBrochureUrl != null ? !planBrochureUrl.equals(product.planBrochureUrl) : product.planBrochureUrl != null)
            return false;
        if (benefitsSumaryUrl != null ? !benefitsSumaryUrl.equals(product.benefitsSumaryUrl) : product.benefitsSumaryUrl != null)
            return false;
        if (drugFormulaUrl != null ? !drugFormulaUrl.equals(product.drugFormulaUrl) : product.drugFormulaUrl != null)
            return false;
        if (isDentalIncluded != null ? !isDentalIncluded.equals(product.isDentalIncluded) : product.isDentalIncluded != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (planName != null ? planName.hashCode() : 0);
        result = 31 * result + (lineOfBusiness != null ? lineOfBusiness.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (ratingArea != null ? ratingArea.hashCode() : 0);
        result = 31 * result + (isAdultChildOnly != null ? isAdultChildOnly.hashCode() : 0);
        result = 31 * result + (networkUrl != null ? networkUrl.hashCode() : 0);
        result = 31 * result + (planBrochureUrl != null ? planBrochureUrl.hashCode() : 0);
        result = 31 * result + (benefitsSumaryUrl != null ? benefitsSumaryUrl.hashCode() : 0);
        result = 31 * result + (drugFormulaUrl != null ? drugFormulaUrl.hashCode() : 0);
        result = 31 * result + (isDentalIncluded != null ? isDentalIncluded.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<AccountProduct> getAccountProductsByProductId() {
        return accountProductsByProductId;
    }

    public void setAccountProductsByProductId(Collection<AccountProduct> accountProductsByProductId) {
        this.accountProductsByProductId = accountProductsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "metal_level_id", referencedColumnName = "metal_level_id")
    public MetalLevel getMetalLevelByMetalLevelId() {
        return metalLevelByMetalLevelId;
    }

    public void setMetalLevelByMetalLevelId(MetalLevel metalLevelByMetalLevelId) {
        this.metalLevelByMetalLevelId = metalLevelByMetalLevelId;
    }

    @ManyToOne
    @JoinColumn(name = "company_code", referencedColumnName = "company_code")
    public Company getCompanyByCompanyCode() {
        return companyByCompanyCode;
    }

    public void setCompanyByCompanyCode(Company companyByCompanyCode) {
        this.companyByCompanyCode = companyByCompanyCode;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ProductQuote> getProductQuotesByProductId() {
        return productQuotesByProductId;
    }

    public void setProductQuotesByProductId(Collection<ProductQuote> productQuotesByProductId) {
        this.productQuotesByProductId = productQuotesByProductId;
    }
}
