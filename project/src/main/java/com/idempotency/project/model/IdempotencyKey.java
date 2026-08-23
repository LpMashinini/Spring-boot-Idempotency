package com.idempotency.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor

public class IdempotencyKey {

    @Id
    private String key;
    private String response;
    private LocalDateTime expiryDate;
}
