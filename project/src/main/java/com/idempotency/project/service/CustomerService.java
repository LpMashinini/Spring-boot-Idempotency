package com.idempotency.project.service;

import com.idempotency.project.model.Customer;
import com.idempotency.project.model.IdempotencyKey;
import com.idempotency.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private IdempotencyKey idempotencyKeyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<String> createCustomerWithIdempotency(String idempotencyKey, Customer customer){

        return ResponseEntity.ok("hello");
    }
}
