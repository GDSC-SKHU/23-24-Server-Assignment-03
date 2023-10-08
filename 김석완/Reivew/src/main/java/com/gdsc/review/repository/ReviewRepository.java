package com.gdsc.review.repository;

import com.gdsc.review.domain.Review;
import java.util.List;

public interface ReviewRepository {

    void save(Review review);
    Review findById(Long id);
    List<Review> findByRestaurantName(String restaurantName);
    List<Review> findByReviewerName(String reviewerName);

    List<Review> findAll();
    void updateById(Long id, Review review);
    void deleteById(Long id);
}
