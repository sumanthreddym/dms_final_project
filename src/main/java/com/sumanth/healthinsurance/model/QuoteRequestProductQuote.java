package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "QUOTE_REQUEST_PRODUCT_QUOTE", schema = "INSURANCE_COMPANY", catalog = "")
public class QuoteRequestProductQuote {
    private String quoteRequestProductQuoteId;
    private String isAccepted;
    @JsonBackReference(value = "quote-request-product-quote-quote-request")
    private QuoteRequest quoteRequestByQuoteRequestId;
    @JsonBackReference(value = "quote-request-product-quote-product-quote")
    private ProductQuote productQuoteByProductQuoteId;

    @Id
    @Column(name = "quote_request_product_quote_id")
    public String getQuoteRequestProductQuoteId() {
        return quoteRequestProductQuoteId;
    }

    public void setQuoteRequestProductQuoteId(String quoteRequestProductQuoteId) {
        this.quoteRequestProductQuoteId = quoteRequestProductQuoteId;
    }

    @Basic
    @Column(name = "is_accepted")
    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteRequestProductQuote that = (QuoteRequestProductQuote) o;

        if (quoteRequestProductQuoteId != null ? !quoteRequestProductQuoteId.equals(that.quoteRequestProductQuoteId) : that.quoteRequestProductQuoteId != null)
            return false;
        if (isAccepted != null ? !isAccepted.equals(that.isAccepted) : that.isAccepted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quoteRequestProductQuoteId != null ? quoteRequestProductQuoteId.hashCode() : 0;
        result = 31 * result + (isAccepted != null ? isAccepted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "quote_request_id", referencedColumnName = "quote_request_id")
    public QuoteRequest getQuoteRequestByQuoteRequestId() {
        return quoteRequestByQuoteRequestId;
    }

    public void setQuoteRequestByQuoteRequestId(QuoteRequest quoteRequestByQuoteRequestId) {
        this.quoteRequestByQuoteRequestId = quoteRequestByQuoteRequestId;
    }

    @ManyToOne
    @JoinColumn(name = "product_quote_id", referencedColumnName = "product_quote_id")
    public ProductQuote getProductQuoteByProductQuoteId() {
        return productQuoteByProductQuoteId;
    }

    public void setProductQuoteByProductQuoteId(ProductQuote productQuoteByProductQuoteId) {
        this.productQuoteByProductQuoteId = productQuoteByProductQuoteId;
    }
}
