package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {
    private String companyCode;
    private String companyName;
    private String customerServicePhone;
    @JsonManagedReference(value = "associate-company")
    private Collection<Associate> associatesByCompanyCode;
    @JsonBackReference(value = "company-address")
    private Address addressByAddressId;
    @JsonManagedReference(value = "product-company")
    private Collection<Product> productsByCompanyCode;

    @Id
    @Column(name = "company_code")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "customer_service_phone")
    public String getCustomerServicePhone() {
        return customerServicePhone;
    }

    public void setCustomerServicePhone(String customerServicePhone) {
        this.customerServicePhone = customerServicePhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (companyCode != null ? !companyCode.equals(company.companyCode) : company.companyCode != null) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (customerServicePhone != null ? !customerServicePhone.equals(company.customerServicePhone) : company.customerServicePhone != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyCode != null ? companyCode.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (customerServicePhone != null ? customerServicePhone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "companyByCompanyCode")
    public Collection<Associate> getAssociatesByCompanyCode() {
        return associatesByCompanyCode;
    }

    public void setAssociatesByCompanyCode(Collection<Associate> associatesByCompanyCode) {
        this.associatesByCompanyCode = associatesByCompanyCode;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "companyByCompanyCode")
    public Collection<Product> getProductsByCompanyCode() {
        return productsByCompanyCode;
    }

    public void setProductsByCompanyCode(Collection<Product> productsByCompanyCode) {
        this.productsByCompanyCode = productsByCompanyCode;
    }
}
