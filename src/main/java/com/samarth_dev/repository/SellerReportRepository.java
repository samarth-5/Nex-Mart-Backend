package com.samarth_dev.repository;

import com.samarth_dev.modal.Seller;
import com.samarth_dev.modal.SellerReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerReportRepository extends JpaRepository<SellerReport,Long> {

    SellerReport findBySellerId(Long sellerId);
}
