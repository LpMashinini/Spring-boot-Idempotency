package com.idempotency.project.repository;

import com.idempotency.project.model.IdempotencyKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotencyRepository extends JpaRepository<IdempotencyKey, Long> {

}
