package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Customer {
    private String customerSsn;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String suffix;
    private Timestamp dateOfBirth;
    private String salutation;
    private String emailAddress;
    private String gender;
    private String preferredLanguage;
    private String phoneNumber;
    @JsonManagedReference(value="account-member-customer")
    private Collection<AccountMember> accountMembersByCustomerSsn;
    @JsonManagedReference(value="chronic-disease-customer-customer")
    private Collection<ChronicDiseaseCustomer> chronicDiseaseCustomersByCustomerSsn;
    @JsonBackReference(value="customer-address")
    private Address addressByAddressId;
    @JsonManagedReference(value="customer-image-customer")
    private Collection<CustomerImage> customerImagesByCustomerSsn;
    @JsonManagedReference(value="customer-relation-customer")
    private Collection<CustomerRelation> customerRelationsByCustomerSsn;
    @JsonManagedReference(value="customer-relation-0-customer")
    private Collection<CustomerRelation> customerRelationsByCustomerSsn_0;
    @JsonManagedReference(value="invoice-customer")
    private Collection<Invoice> invoicesByCustomerSsn;
    @JsonManagedReference(value="quote-request-customer")
    private Collection<QuoteRequest> quoteRequestsByCustomerSsn;

    @Id
    @Column(name = "customer_ssn")
    public String getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(String customerSsn) {
        this.customerSsn = customerSsn;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middle_initial")
    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "suffix")
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "salutation")
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Basic
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "preferred_language")
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerSsn != null ? !customerSsn.equals(customer.customerSsn) : customer.customerSsn != null)
            return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (middleInitial != null ? !middleInitial.equals(customer.middleInitial) : customer.middleInitial != null)
            return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (suffix != null ? !suffix.equals(customer.suffix) : customer.suffix != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(customer.dateOfBirth) : customer.dateOfBirth != null)
            return false;
        if (salutation != null ? !salutation.equals(customer.salutation) : customer.salutation != null) return false;
        if (emailAddress != null ? !emailAddress.equals(customer.emailAddress) : customer.emailAddress != null)
            return false;
        if (gender != null ? !gender.equals(customer.gender) : customer.gender != null) return false;
        if (preferredLanguage != null ? !preferredLanguage.equals(customer.preferredLanguage) : customer.preferredLanguage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerSsn != null ? customerSsn.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleInitial != null ? middleInitial.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (salutation != null ? salutation.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (preferredLanguage != null ? preferredLanguage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerSsn")
    public Collection<AccountMember> getAccountMembersByCustomerSsn() {
        return accountMembersByCustomerSsn;
    }

    public void setAccountMembersByCustomerSsn(Collection<AccountMember> accountMembersByCustomerSsn) {
        this.accountMembersByCustomerSsn = accountMembersByCustomerSsn;
    }

    @OneToMany(mappedBy = "customerByCustomerSsn")
    public Collection<ChronicDiseaseCustomer> getChronicDiseaseCustomersByCustomerSsn() {
        return chronicDiseaseCustomersByCustomerSsn;
    }

    public void setChronicDiseaseCustomersByCustomerSsn(Collection<ChronicDiseaseCustomer> chronicDiseaseCustomersByCustomerSsn) {
        this.chronicDiseaseCustomersByCustomerSsn = chronicDiseaseCustomersByCustomerSsn;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "customerByCustomerSsn")
    public Collection<CustomerImage> getCustomerImagesByCustomerSsn() {
        return customerImagesByCustomerSsn;
    }

    public void setCustomerImagesByCustomerSsn(Collection<CustomerImage> customerImagesByCustomerSsn) {
        this.customerImagesByCustomerSsn = customerImagesByCustomerSsn;
    }

    @OneToMany(mappedBy = "customerByCustomer1Ssn")
    public Collection<CustomerRelation> getCustomerRelationsByCustomerSsn() {
        return customerRelationsByCustomerSsn;
    }

    public void setCustomerRelationsByCustomerSsn(Collection<CustomerRelation> customerRelationsByCustomerSsn) {
        this.customerRelationsByCustomerSsn = customerRelationsByCustomerSsn;
    }

    @OneToMany(mappedBy = "customerByCustomer2Ssn")
    public Collection<CustomerRelation> getCustomerRelationsByCustomerSsn_0() {
        return customerRelationsByCustomerSsn_0;
    }

    public void setCustomerRelationsByCustomerSsn_0(Collection<CustomerRelation> customerRelationsByCustomerSsn_0) {
        this.customerRelationsByCustomerSsn_0 = customerRelationsByCustomerSsn_0;
    }

    @OneToMany(mappedBy = "customerByCustomerSsn")
    public Collection<Invoice> getInvoicesByCustomerSsn() {
        return invoicesByCustomerSsn;
    }

    public void setInvoicesByCustomerSsn(Collection<Invoice> invoicesByCustomerSsn) {
        this.invoicesByCustomerSsn = invoicesByCustomerSsn;
    }

    @OneToMany(mappedBy = "customerByCustomerSsn")
    public Collection<QuoteRequest> getQuoteRequestsByCustomerSsn() {
        return quoteRequestsByCustomerSsn;
    }

    public void setQuoteRequestsByCustomerSsn(Collection<QuoteRequest> quoteRequestsByCustomerSsn) {
        this.quoteRequestsByCustomerSsn = quoteRequestsByCustomerSsn;
    }
}
