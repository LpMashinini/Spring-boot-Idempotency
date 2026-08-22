package com.idempotency.project.service;

import com.idempotency.project.model.IdempotencyKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private IdempotencyKey idempotencyKeyRepository;
}
