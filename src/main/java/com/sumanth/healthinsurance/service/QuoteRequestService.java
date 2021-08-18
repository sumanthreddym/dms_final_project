package com.sumanth.healthinsurance.service;

import com.sumanth.healthinsurance.model.Customer;
import com.sumanth.healthinsurance.model.ProductQuote;
import com.sumanth.healthinsurance.model.QuoteRequest;
import com.sumanth.healthinsurance.repository.CustomerRepository;
import com.sumanth.healthinsurance.repository.QuoteRepository;
import com.sumanth.healthinsurance.repository.QuoteRequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteRequestService {
    final QuoteRequestRepository quoteRequestRepository;
    final CustomerRepository customerRepository;
    public QuoteRequestService(QuoteRequestRepository quoteRequestRepository, CustomerRepository customerRepository) {
        this.quoteRequestRepository = quoteRequestRepository;
        this.customerRepository = customerRepository;
    }

    public List<QuoteRequest> listQuoteRequestsByCustomerSsn(String customerSsn){

        List<QuoteRequest> quoteRequests = new ArrayList<>();

        quoteRequestRepository.findAll().forEach(quoteRequest -> {
            if(quoteRequest.getCustomerByCustomerSsn().getCustomerSsn().equals(customerSsn)){
                quoteRequests.add(quoteRequest);
            }
        });
        return quoteRequests;
    }

    public List<QuoteRequest> listQuoteRequests(){
        return (List<QuoteRequest>) quoteRequestRepository.findAll();
    }

    public QuoteRequest createQuoteRequest(QuoteRequest quoteRequest){
        return quoteRequestRepository.save(quoteRequest);
    }
}
