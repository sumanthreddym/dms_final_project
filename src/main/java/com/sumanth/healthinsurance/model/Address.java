package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Address {
    private String addressId;
    private String addressDetail;
    private String city;
    private String state;
    private String zipcode;
    private Timestamp startDate;
    private Timestamp endDate;
    private Byte isCurrentAddress;
    @JsonManagedReference(value = "associate-address")
    private Collection<Associate> associatesByAddressId;
    @JsonManagedReference(value = "billing-account-address")
    private Collection<BillingAccount> billingAccountsByAddressId;
    @JsonManagedReference(value = "company-address")
    private Collection<Company> companiesByAddressId;
    @JsonManagedReference(value = "customer-address")
    private Collection<Customer> customersByAddressId;

    @Id
    @Column(name = "address_id")
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address_detail")
    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

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
    @Column(name = "is_current_address")
    public Byte getIsCurrentAddress() {
        return isCurrentAddress;
    }

    public void setIsCurrentAddress(Byte isCurrentAddress) {
        this.isCurrentAddress = isCurrentAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != null ? !addressId.equals(address.addressId) : address.addressId != null) return false;
        if (addressDetail != null ? !addressDetail.equals(address.addressDetail) : address.addressDetail != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (zipcode != null ? !zipcode.equals(address.zipcode) : address.zipcode != null) return false;
        if (startDate != null ? !startDate.equals(address.startDate) : address.startDate != null) return false;
        if (endDate != null ? !endDate.equals(address.endDate) : address.endDate != null) return false;
        if (isCurrentAddress != null ? !isCurrentAddress.equals(address.isCurrentAddress) : address.isCurrentAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId != null ? addressId.hashCode() : 0;
        result = 31 * result + (addressDetail != null ? addressDetail.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (isCurrentAddress != null ? isCurrentAddress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Associate> getAssociatesByAddressId() {
        return associatesByAddressId;
    }

    public void setAssociatesByAddressId(Collection<Associate> associatesByAddressId) {
        this.associatesByAddressId = associatesByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<BillingAccount> getBillingAccountsByAddressId() {
        return billingAccountsByAddressId;
    }

    public void setBillingAccountsByAddressId(Collection<BillingAccount> billingAccountsByAddressId) {
        this.billingAccountsByAddressId = billingAccountsByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Company> getCompaniesByAddressId() {
        return companiesByAddressId;
    }

    public void setCompaniesByAddressId(Collection<Company> companiesByAddressId) {
        this.companiesByAddressId = companiesByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Customer> getCustomersByAddressId() {
        return customersByAddressId;
    }

    public void setCustomersByAddressId(Collection<Customer> customersByAddressId) {
        this.customersByAddressId = customersByAddressId;
    }
}
