package com.samarth_dev.service;

import com.samarth_dev.modal.Product;
import com.samarth_dev.modal.Review;
import com.samarth_dev.modal.User;
import com.samarth_dev.request.CreateReviewRequest;

import java.util.List;

public interface ReviewService {

    Review createReview(CreateReviewRequest req, User user, Product product);

    List<Review> getReviewByProductId(Long productId);

    Review updateReview(Long reviewId, String reviewText, double rating, Long userId) throws Exception;

    void deleteReview(Long reviewId, Long userId) throws Exception;

    Review getReviewById(Long reviewId) throws Exception;
}
