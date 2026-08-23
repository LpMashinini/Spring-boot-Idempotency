package com.idempotency.project.controller;

import com.idempotency.project.model.Customer;
import com.idempotency.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("/api/customer")
    public ResponseEntity<String>  createCustomer(@RequestHeader("Idempotency-key") String idempotencyKey, @RequestBody Customer customer){

        return customerService.createCustomerWithIdempotency(idempotencyKey, customer);
    }
}
