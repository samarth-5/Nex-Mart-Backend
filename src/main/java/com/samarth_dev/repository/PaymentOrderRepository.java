package com.samarth_dev.repository;

import com.samarth_dev.modal.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long> {

    PaymentOrder findByPaymentLinkId(String paymentId);
}
