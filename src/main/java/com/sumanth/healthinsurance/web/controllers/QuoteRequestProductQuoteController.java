package com.sumanth.healthinsurance.web.controllers;

import com.sumanth.healthinsurance.dto.QuoteRequestProductQuoteDTO;
import com.sumanth.healthinsurance.model.ProductQuote;
import com.sumanth.healthinsurance.model.QuoteRequest;
import com.sumanth.healthinsurance.model.QuoteRequestProductQuote;
import com.sumanth.healthinsurance.service.QuoteRequestProductQuoteService;
import com.sumanth.healthinsurance.service.QuoteRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/quote_request_product_quotes")
public class QuoteRequestProductQuoteController {

    QuoteRequestProductQuoteService quoteRequestProductQuoteService;

    @Autowired
    public QuoteRequestProductQuoteController(QuoteRequestProductQuoteService quoteRequestProductQuoteService){
        this.quoteRequestProductQuoteService = quoteRequestProductQuoteService;
    }

    @GetMapping(value="/{customer_ssn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuoteRequestProductQuoteDTO> listQuoteRequestProductQuotes(@PathVariable("customer_ssn") String customerSsn){
        List<QuoteRequestProductQuoteDTO> quoteRequestProductQuoteDTOs = new ArrayList<>();
        List<QuoteRequestProductQuote> quoteRequestProductQuotes = quoteRequestProductQuoteService.listQuoteRequestProductQuotes(customerSsn);


        quoteRequestProductQuotes.forEach(quoteRequestProductQuote -> {
            quoteRequestProductQuoteDTOs.add(
                    new QuoteRequestProductQuoteDTO(quoteRequestProductQuote.getQuoteRequestProductQuoteId(),
                    quoteRequestProductQuote.getIsAccepted(),
                    quoteRequestProductQuote.getProductQuoteByProductQuoteId().getCharges(),
                quoteRequestProductQuote.getProductQuoteByProductQuoteId().getProductByProductId()
            ));
        });
        return quoteRequestProductQuoteDTOs;
    }

}
