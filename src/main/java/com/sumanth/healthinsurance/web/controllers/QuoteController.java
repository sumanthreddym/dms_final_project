package com.sumanth.healthinsurance.web.controllers;

import com.sumanth.healthinsurance.model.ProductQuote;
import com.sumanth.healthinsurance.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/quotes")
public class QuoteController {

    QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductQuote> listQuotes(){
        return quoteService.listQuotes();
    }
}
