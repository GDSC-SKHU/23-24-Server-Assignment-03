package com.gdsc.review.dto;

import lombok.Data;
import lombok.Builder;

@Data
public class ReviewDto {

    private Long id;
    private String restaurantName;
    private String reviewerName;
    private String content;
    private int rating;

    @Builder
    public ReviewDto(Long id, String restaurantName, String reviewerName, String content, int rating){
        this.id = id;
        this.restaurantName = restaurantName;
        this.reviewerName = reviewerName;
        this.content = content;
        this.rating = rating;
    }


}
