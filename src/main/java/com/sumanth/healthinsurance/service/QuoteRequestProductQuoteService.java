package com.sumanth.healthinsurance.service;

import com.sumanth.healthinsurance.model.ProductQuote;
import com.sumanth.healthinsurance.model.QuoteRequest;
import com.sumanth.healthinsurance.model.QuoteRequestProductQuote;
import com.sumanth.healthinsurance.repository.QuoteRepository;
import com.sumanth.healthinsurance.repository.QuoteRequestProductQuoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteRequestProductQuoteService {
    final QuoteRequestProductQuoteRepository quoteRequestProductQuoteRepository;

    public QuoteRequestProductQuoteService(QuoteRequestProductQuoteRepository quoteRequestProductQuoteRepository) {
        this.quoteRequestProductQuoteRepository = quoteRequestProductQuoteRepository;
    }

    public List<QuoteRequestProductQuote> listQuoteRequestProductQuotes(String customerSsn){
        List<QuoteRequestProductQuote> quoteRequestProductQuotes = new ArrayList<>();

        quoteRequestProductQuoteRepository.findAll().forEach(quoteRequestProductQuote -> {
            if(quoteRequestProductQuote.getQuoteRequestByQuoteRequestId().getCustomerByCustomerSsn().getCustomerSsn().equals(customerSsn)){
                quoteRequestProductQuotes.add(quoteRequestProductQuote);
            }
        });
        return quoteRequestProductQuotes;
    }
}
