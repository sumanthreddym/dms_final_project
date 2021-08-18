package com.sumanth.healthinsurance.service;

import com.sumanth.healthinsurance.model.ProductQuote;
import com.sumanth.healthinsurance.model.QuoteRequest;
import com.sumanth.healthinsurance.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {
    final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<ProductQuote> listQuotes(){
        return (List<ProductQuote>) quoteRepository.findAll();
    }
}
