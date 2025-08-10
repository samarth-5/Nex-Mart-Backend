package com.samarth_dev.service;

import com.samarth_dev.modal.Product;
import com.samarth_dev.modal.User;
import com.samarth_dev.modal.Wishlist;
import org.springframework.stereotype.Service;

public interface WishlistService {

    Wishlist createWishlist(User user);
    Wishlist getWishlistByUserId(User user);
    Wishlist addProductToWishlist(User user, Product product);
}
