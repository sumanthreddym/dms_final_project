package com.sumanth.healthinsurance.dto;

import com.sumanth.healthinsurance.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class QuoteRequestDTO {
    private String quoteRequestId;
    private Integer numberOfPeopleOnPlan;
    private Double bmi;
    private Byte isSmoker;
    private Double maxPrice;
    private Byte isSaleComplete;
    private Customer customerByCustomerSsn;
    private Associate associateByAssociateSsn;
    private Region regionByRegionId;
    private MetalLevel metalLevelByMetalLevelId;
    private Collection<QuoteRequestProductQuote> quoteRequestProductQuotesByQuoteRequestId;
}
