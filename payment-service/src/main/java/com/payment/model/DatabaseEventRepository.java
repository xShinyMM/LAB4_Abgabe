package com.payment.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseEventRepository extends JpaRepository<DatabaseEvent, Long> {
    List<DatabaseEvent> findByProcessedFalse();
}

