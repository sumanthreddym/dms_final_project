package com.sumanth.healthinsurance.repository;

import com.sumanth.healthinsurance.model.ProductQuote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository  extends CrudRepository<ProductQuote, String> {
}
