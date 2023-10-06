package com.example.post_api.post.repository;


import com.example.post_api.domain.Post;
import com.example.post_api.post.dto.UpdatePostRequest;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    void update(UpdatePostRequest updateParam, Post post);

    void delete(Post post);

    Optional<Post> findById(Long postId);

    List<Post> findAll();
}
