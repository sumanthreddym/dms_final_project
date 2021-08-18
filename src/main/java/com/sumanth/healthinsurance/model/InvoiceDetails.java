package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "INVOICE_DETAILS", schema = "INSURANCE_COMPANY", catalog = "")
public class InvoiceDetails {
    private String invoiceLineNumber;
    private Byte isConversionPending;
    private Byte isPaid;
    private Double premiumSubTotal;
    private Timestamp dueDate;
    private Timestamp paidDate;
    private Timestamp runDate;
    @JsonBackReference(value = "invoice-details-invoice")
    private Invoice invoiceByInvoiceId;

    @Id
    @Column(name = "invoice_line_number")
    public String getInvoiceLineNumber() {
        return invoiceLineNumber;
    }

    public void setInvoiceLineNumber(String invoiceLineNumber) {
        this.invoiceLineNumber = invoiceLineNumber;
    }

    @Basic
    @Column(name = "is_conversion_pending")
    public Byte getIsConversionPending() {
        return isConversionPending;
    }

    public void setIsConversionPending(Byte isConversionPending) {
        this.isConversionPending = isConversionPending;
    }

    @Basic
    @Column(name = "is_paid")
    public Byte getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Byte isPaid) {
        this.isPaid = isPaid;
    }

    @Basic
    @Column(name = "premium_sub_total")
    public Double getPremiumSubTotal() {
        return premiumSubTotal;
    }

    public void setPremiumSubTotal(Double premiumSubTotal) {
        this.premiumSubTotal = premiumSubTotal;
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

        InvoiceDetails that = (InvoiceDetails) o;

        if (invoiceLineNumber != null ? !invoiceLineNumber.equals(that.invoiceLineNumber) : that.invoiceLineNumber != null)
            return false;
        if (isConversionPending != null ? !isConversionPending.equals(that.isConversionPending) : that.isConversionPending != null)
            return false;
        if (isPaid != null ? !isPaid.equals(that.isPaid) : that.isPaid != null) return false;
        if (premiumSubTotal != null ? !premiumSubTotal.equals(that.premiumSubTotal) : that.premiumSubTotal != null)
            return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (paidDate != null ? !paidDate.equals(that.paidDate) : that.paidDate != null) return false;
        if (runDate != null ? !runDate.equals(that.runDate) : that.runDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceLineNumber != null ? invoiceLineNumber.hashCode() : 0;
        result = 31 * result + (isConversionPending != null ? isConversionPending.hashCode() : 0);
        result = 31 * result + (isPaid != null ? isPaid.hashCode() : 0);
        result = 31 * result + (premiumSubTotal != null ? premiumSubTotal.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (paidDate != null ? paidDate.hashCode() : 0);
        result = 31 * result + (runDate != null ? runDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    public Invoice getInvoiceByInvoiceId() {
        return invoiceByInvoiceId;
    }

    public void setInvoiceByInvoiceId(Invoice invoiceByInvoiceId) {
        this.invoiceByInvoiceId = invoiceByInvoiceId;
    }
}
