package com.idempotency.project.service;

import com.idempotency.project.model.Customer;
import com.idempotency.project.model.IdempotencyKey;
import com.idempotency.project.repository.CustomerRepository;
import com.idempotency.project.repository.IdempotencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private IdempotencyRepository idempotencyKeyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<String> createCustomerWithIdempotency(String idempotencyKey, Customer customer){

        IdempotencyKey savedKey = idempotencyKeyRepository.findById(idempotencyKey).orElse(null);

        if (savedKey.getExpiryDate().isBefore(LocalDateTime.now())){
            idempotencyKeyRepository.delete(savedKey);
        } else {
            return ResponseEntity.ok(savedKey.getResponse());
        }

        Customer savedCustomer = customerRepository.save(customer);
        String response = "Customer created with ID: " + savedCustomer.getId();


        IdempotencyKey newKey = new IdempotencyKey();
        newKey.setKey(idempotencyKey);
        newKey.setResponse(response);
        newKey.setExpiryDate(LocalDateTime.now().plusHours(24));
        idempotencyKeyRepository.save(newKey);


        return ResponseEntity.ok(response);
    }
}
