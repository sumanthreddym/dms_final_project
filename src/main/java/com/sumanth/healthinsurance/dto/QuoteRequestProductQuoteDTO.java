package com.sumanth.healthinsurance.dto;

import com.sumanth.healthinsurance.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuoteRequestProductQuoteDTO {
    private String quoteRequestProductQuoteId;
    private String isAccepted;
    private Double charges;
    private Product product;
}
