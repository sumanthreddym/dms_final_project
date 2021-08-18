package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Invoice {
    private String invoiceId;
    private Timestamp dueDate;
    private Timestamp paidDate;
    private Timestamp runDate;
    @JsonBackReference(value="invoice-billing-account")
    private BillingAccount billingAccountByBillingAccountId;
    @JsonBackReference(value="invoice-customer")
    private Customer customerByCustomerSsn;
    @JsonManagedReference(value="invoice-details-invoice")
    private Collection<InvoiceDetails> invoiceDetailsByInvoiceId;

    @Id
    @Column(name = "invoice_id")
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "due_date")
    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "paid_date")
    public Timestamp getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate;
    }

    @Basic
    @Column(name = "run_date")
    public Timestamp getRunDate() {
        return runDate;
    }

    public void setRunDate(Timestamp runDate) {
        this.runDate = runDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (invoiceId != null ? !invoiceId.equals(invoice.invoiceId) : invoice.invoiceId != null) return false;
        if (dueDate != null ? !dueDate.equals(invoice.dueDate) : invoice.dueDate != null) return false;
        if (paidDate != null ? !paidDate.equals(invoice.paidDate) : invoice.paidDate != null) return false;
        if (runDate != null ? !runDate.equals(invoice.runDate) : invoice.runDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dueDate != null ? dueDate.hashCode() : 0;
        result = 31 * result + (paidDate != null ? paidDate.hashCode() : 0);
        result = 31 * result + (runDate != null ? runDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "billing_account_id", referencedColumnName = "billing_account_id")
    public BillingAccount getBillingAccountByBillingAccountId() {
        return billingAccountByBillingAccountId;
    }

    public void setBillingAccountByBillingAccountId(BillingAccount billingAccountByBillingAccountId) {
        this.billingAccountByBillingAccountId = billingAccountByBillingAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_ssn", referencedColumnName = "customer_ssn")
    public Customer getCustomerByCustomerSsn() {
        return customerByCustomerSsn;
    }

    public void setCustomerByCustomerSsn(Customer customerByCustomerSsn) {
        this.customerByCustomerSsn = customerByCustomerSsn;
    }

    @OneToMany(mappedBy = "invoiceByInvoiceId")
    public Collection<InvoiceDetails> getInvoiceDetailsByInvoiceId() {
        return invoiceDetailsByInvoiceId;
    }

    public void setInvoiceDetailsByInvoiceId(Collection<InvoiceDetails> invoiceDetailsByInvoiceId) {
        this.invoiceDetailsByInvoiceId = invoiceDetailsByInvoiceId;
    }
}
