package com.payment.repository;

import com.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // keine Methoden notwendig – save(), findById(), findAll() etc. sind automatisch verfügbar
}
