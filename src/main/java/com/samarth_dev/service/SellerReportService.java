package com.samarth_dev.service;

import com.samarth_dev.modal.Seller;
import com.samarth_dev.modal.SellerReport;

public interface SellerReportService {

    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport(SellerReport sellerReport);
}
