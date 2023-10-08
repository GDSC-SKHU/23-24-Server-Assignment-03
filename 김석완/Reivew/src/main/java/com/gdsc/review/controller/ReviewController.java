package com.gdsc.review.controller;

import com.gdsc.review.dto.ReviewDto;
import com.gdsc.review.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;
    
    
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("reviews")
    public void save(@RequestBody ReviewDto reviewDto) {
        reviewService.saveReview(reviewDto);
    }

    @GetMapping("reviews_id/{id}")
    public ReviewDto findReviewById(@PathVariable Long id) {
        return reviewService.findReviewById(id);
    }

    @GetMapping("reviews_restaurant/{restaurantName}")
    public List<ReviewDto> findReviewByRestaurantName(@PathVariable String restaurantName) {
        return reviewService.findReviewByRestaurantName(restaurantName);
    }

    @GetMapping("reviews_reviewer/{reviewerName}")
    public List<ReviewDto> findReviewByReviewerName(@PathVariable String reviewerName) {
        return reviewService.findReviewByReviewerName(reviewerName);
    }

    @GetMapping("reviews")
    public List<ReviewDto> findAllReview() {
        return reviewService.findAllReview();
    }

    @PatchMapping("reviews/{id}")
    public void updateReviewById(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        reviewService.updateReviewById(id, reviewDto);
    }

    @DeleteMapping("reviews/{id}")
    public void deleteReviewById(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
    }


}
