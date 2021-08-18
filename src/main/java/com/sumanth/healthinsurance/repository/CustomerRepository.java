package com.sumanth.healthinsurance.repository;

import com.sumanth.healthinsurance.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
