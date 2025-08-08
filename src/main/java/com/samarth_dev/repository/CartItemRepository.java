package com.samarth_dev.repository;

import com.samarth_dev.modal.Cart;
import com.samarth_dev.modal.CartItem;
import com.samarth_dev.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);
}
