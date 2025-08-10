package com.samarth_dev.repository;

import com.samarth_dev.modal.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {

    Coupon findByCode(String code);
}
