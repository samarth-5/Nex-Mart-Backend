package com.samarth_dev.repository;

import com.samarth_dev.modal.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,Long> {

    Wishlist findByUserId(Long userId);
}
