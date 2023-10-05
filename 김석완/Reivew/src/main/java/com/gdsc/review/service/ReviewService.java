package com.gdsc.review.service;

import com.gdsc.review.domain.Review;
import com.gdsc.review.dto.ReviewDto;
import com.gdsc.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(ReviewDto reviewDto){
        Review review = Review.builder()
                        .restaurantName(reviewDto.getRestaurantName())
                        .reviewerName(reviewDto.getReviewerName())
                        .content(reviewDto.getContent())
                        .rating(reviewDto.getRating())
                        .build();
        reviewRepository.save(review);
    }

    public ReviewDto findReviewById(Long id){
        Review review = reviewRepository.findById(id);

        return ReviewDto.builder()
                .id(review.getId())
                .restaurantName(review.getRestaurantName())
                .reviewerName(review.getReviewerName())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
    }

    public List<ReviewDto> findReviewByRestaurantName(String restaurantName){
        List<Review> reviews = reviewRepository.findByRestaurantName(restaurantName);

        return reviews.stream()
                .map(review -> ReviewDto.builder()
                        .id(review.getId())
                        .restaurantName(review.getRestaurantName())
                        .reviewerName(review.getReviewerName())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .build())
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findReviewByReviewerName(String reviewerName){
        List<Review> reviews = reviewRepository.findByReviewerName(reviewerName);

        return reviews.stream()
                .map(review -> ReviewDto.builder()
                        .id(review.getId())
                        .restaurantName(review.getRestaurantName())
                        .reviewerName(review.getReviewerName())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .build())
                .collect(Collectors.toList());
    }
    public List<ReviewDto> findAllReview(){
        return reviewRepository.findAll()
                .stream()
                .map(review -> ReviewDto.builder()
                        .id(review.getId())
                        .restaurantName(review.getRestaurantName())
                        .reviewerName(review.getReviewerName())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .build())
                .toList();
    }

    public void updateReviewById(Long id, ReviewDto reviewDto){
        Review findReview = reviewRepository.findById(id);
        findReview.updateReview(reviewDto.getRestaurantName(), reviewDto.getReviewerName(), reviewDto.getContent(), reviewDto.getRating());

        reviewRepository.updateById(id, findReview);
    }
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
