package com.samarth_dev.service;

import com.samarth_dev.modal.Cart;
import com.samarth_dev.modal.CartItem;
import com.samarth_dev.modal.Product;
import com.samarth_dev.modal.User;

public interface CartService {

    public CartItem addCartItem(User user, Product product, String size, int quantity);

    public Cart findUserCart(User user);
}
