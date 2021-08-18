package com.sumanth.healthinsurance.web.controllers;

import com.sumanth.healthinsurance.dto.QuoteRequestDTO;
import com.sumanth.healthinsurance.dto.QuoteRequestProductQuoteDTO;
import com.sumanth.healthinsurance.model.*;
import com.sumanth.healthinsurance.service.QuoteRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/quote_requests")
public class QuoteRequestController {

    QuoteRequestService quoteRequestService;

    @Autowired
    public QuoteRequestController(QuoteRequestService quoteRequestService){
        this.quoteRequestService = quoteRequestService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuoteRequestDTO> listQuoteRequests(){
        List<QuoteRequestDTO> quoteRequestDTOs = new ArrayList<>();
        List<QuoteRequest> quoteRequests = quoteRequestService.listQuoteRequests();

        quoteRequests.forEach(quoteRequest -> {
            quoteRequestDTOs.add(
                    new QuoteRequestDTO(
                            quoteRequest.getQuoteRequestId(),
                            quoteRequest.getNumberOfPeopleOnPlan(),
                            quoteRequest.getBmi(),
                            quoteRequest.getIsSmoker(),
                            quoteRequest.getMaxPrice(),
                            quoteRequest.getIsSaleComplete(),
                            quoteRequest.getCustomerByCustomerSsn(),
                            quoteRequest.getAssociateByAssociateSsn(),
                            quoteRequest.getRegionByRegionId(),
                            quoteRequest.getMetalLevelByMetalLevelId(),
                            quoteRequest.getQuoteRequestProductQuotesByQuoteRequestId()
                    ));
        });

        return quoteRequestDTOs;
    }

    @GetMapping(value="/{customer_ssn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuoteRequest> listQuoteRequestsByCustomerSsn(@PathVariable("customer_ssn") String customerSsn){
        return quoteRequestService.listQuoteRequestsByCustomerSsn(customerSsn);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuoteRequest> createQuoteRequest(@RequestBody QuoteRequest quoteRequest){
        return new ResponseEntity<>(quoteRequestService.createQuoteRequest(quoteRequest), HttpStatus.OK);
    }
}
