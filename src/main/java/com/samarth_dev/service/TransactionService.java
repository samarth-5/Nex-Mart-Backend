package com.samarth_dev.service;

import com.samarth_dev.modal.Order;
import com.samarth_dev.modal.Seller;
import com.samarth_dev.modal.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Order order);
    List<Transaction> getTransactionsBySellerId(Seller seller);
    List<Transaction> getAllTransactions();
}

