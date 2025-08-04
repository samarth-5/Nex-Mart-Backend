package com.samarth_dev.repository;

import com.samarth_dev.modal.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {

    Seller findByEmail(String email);
}
