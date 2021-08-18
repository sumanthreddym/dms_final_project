package com.sumanth.healthinsurance.service;

import com.sumanth.healthinsurance.repository.QuoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuoteServiceTest {
//    @InjectMocks QuoteService quoteService;
//
//    @Mock CustomerRepository customerRepository;
//
//
//    @BeforeAll
//    public void initMocks(){
//        MockitoAnnotations.openMocks(this);
//    }

    @Autowired QuoteService quoteService;
    @Autowired QuoteRepository quoteRepository;
    @Test
    void whenCallingSayHello_thenReturnHello() {
        quoteService.listQuotes();
    }
}
