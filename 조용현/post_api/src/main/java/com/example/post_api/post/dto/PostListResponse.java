package com.example.post_api.post.dto;

import com.example.post_api.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostListResponse {
    private Long PostId;
    private String title;

    public static PostListResponse createInstance(Post post) {
        return new PostListResponse(post.getId(), post.getTitle()
        );
    }


}

