package com.samarth_dev.repository;

import com.samarth_dev.domain.AccountStatus;
import com.samarth_dev.modal.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Long> {

    Seller findByEmail(String email);
    List<Seller> findByAccountStatus(AccountStatus status);
}
