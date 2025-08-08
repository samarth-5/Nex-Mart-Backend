package com.samarth_dev.service;

import com.samarth_dev.modal.CartItem;

public interface CartItemService {

    CartItem updateCartItem(Long userId, Long id, CartItem cartItem);
    void removeCartItem(Long userId, Long cartItemId);
    CartItem findCartItemById(Long id);

}
