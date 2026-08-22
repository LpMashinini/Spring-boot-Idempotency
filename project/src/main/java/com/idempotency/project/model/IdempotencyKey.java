package com.idempotency.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class IdempotencyKey {

    @Id
    private String key;
    private String response;
    private LocalDate expiryDate;
}
