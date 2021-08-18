package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Associate {
    private String associateSsn;
    private String fname;
    private String lname;
    private String role;
    private Timestamp dateOfBirth;
    private Timestamp startDate;
    private String phoneNumber;
    private String emailAddress;
    @JsonManagedReference(value = "account-admin-associate")
    private Collection<AccountAdmin> accountAdminsByAssociateSsn;
    @JsonBackReference(value = "associate-address")
    private Address addressByAddressId;
    @JsonBackReference(value = "associate-company")
    private Company companyByCompanyCode;
    @JsonManagedReference(value = "associate-role-associate")
    private Collection<AssociateRole> associateRolesByAssociateSsn;
    @JsonManagedReference(value = "quote-request-associate")
    private Collection<QuoteRequest> quoteRequestsByAssociateSsn;

    @Id
    @Column(name = "associate_ssn")
    public String getAssociateSsn() {
        return associateSsn;
    }

    public void setAssociateSsn(String associateSsn) {
        this.associateSsn = associateSsn;
    }

    @Basic
    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Associate associate = (Associate) o;

        if (associateSsn != null ? !associateSsn.equals(associate.associateSsn) : associate.associateSsn != null)
            return false;
        if (fname != null ? !fname.equals(associate.fname) : associate.fname != null) return false;
        if (lname != null ? !lname.equals(associate.lname) : associate.lname != null) return false;
        if (role != null ? !role.equals(associate.role) : associate.role != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(associate.dateOfBirth) : associate.dateOfBirth != null)
            return false;
        if (startDate != null ? !startDate.equals(associate.startDate) : associate.startDate != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(associate.phoneNumber) : associate.phoneNumber != null)
            return false;
        if (emailAddress != null ? !emailAddress.equals(associate.emailAddress) : associate.emailAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = associateSsn != null ? associateSsn.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "associateByAssociateSsn")
    public Collection<AccountAdmin> getAccountAdminsByAssociateSsn() {
        return accountAdminsByAssociateSsn;
    }

    public void setAccountAdminsByAssociateSsn(Collection<AccountAdmin> accountAdminsByAssociateSsn) {
        this.accountAdminsByAssociateSsn = accountAdminsByAssociateSsn;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "company_code", referencedColumnName = "company_code")
    public Company getCompanyByCompanyCode() {
        return companyByCompanyCode;
    }

    public void setCompanyByCompanyCode(Company companyByCompanyCode) {
        this.companyByCompanyCode = companyByCompanyCode;
    }

    @OneToMany(mappedBy = "associateByAssociateSsn")
    public Collection<AssociateRole> getAssociateRolesByAssociateSsn() {
        return associateRolesByAssociateSsn;
    }

    public void setAssociateRolesByAssociateSsn(Collection<AssociateRole> associateRolesByAssociateSsn) {
        this.associateRolesByAssociateSsn = associateRolesByAssociateSsn;
    }

    @OneToMany(mappedBy = "associateByAssociateSsn")
    public Collection<QuoteRequest> getQuoteRequestsByAssociateSsn() {
        return quoteRequestsByAssociateSsn;
    }

    public void setQuoteRequestsByAssociateSsn(Collection<QuoteRequest> quoteRequestsByAssociateSsn) {
        this.quoteRequestsByAssociateSsn = quoteRequestsByAssociateSsn;
    }
}
