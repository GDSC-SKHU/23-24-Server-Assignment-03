package com.example.post_api.post.dto;

import com.example.post_api.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPostResponse {
    private Long PostId;
    private String title;
    private String content;

    public static AddPostResponse createInstance(Post post) {
        return new AddPostResponse(post.getId(), post.getTitle(), post.getContent());
    }


}
