package com.gdsc.review.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Review {

    private Long id;
    private String restaurantName;
    private String reviewerName;
    private String content;
    private int rating;

    @Builder
    public Review(String restaurantName, String reviewerName, String content, int rating){
        this.restaurantName = restaurantName;
        this.reviewerName = reviewerName;
        this.content = content;
        this.rating = rating;
    }

    public void initId(Long id) {
        this.id = id;
    }

    public void updateReview(String restaurantName, String reviewerName, String content, int rating){
        this.restaurantName = restaurantName;
        this.reviewerName = reviewerName;
        this.content = content;
        this.rating = rating;
    }
}
