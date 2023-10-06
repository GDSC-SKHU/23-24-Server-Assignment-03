package com.example.post_api.post.dto;

import com.example.post_api.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponse {
    private Long PostId;
    private String title;
    private String content;

    public static PostResponse createInstance(Post post) {
        return new PostResponse(post.getId(), post.getTitle(), post.getContent()
        );
    }



}
