package com.example.post_api.controller;

import com.example.post_api.domain.Post;
import com.example.post_api.post.dto.*;
import com.example.post_api.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/post")
    public Object createPost(@RequestBody AddPostRequest addPostRequest) {
        return new ResponseEntity<>(AddPostResponse.createInstance(postService.savePost(addPostRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/api/post/{postId}")
    public Object findById(@PathVariable Long postId) {
        return PostResponse.createInstance(postService.findById(postId));
    }

    @GetMapping("/api/post")
    public Object findAll() {
        List<Post> findPosts = postService.findAll();
        List<PostListResponse> collect = findPosts.stream().map((m) -> PostListResponse.createInstance(m)).collect(Collectors.toList());
        return Result.createInstance(collect);
    }

    @PatchMapping("/api/post/{id}")
    public Object postUpdate(@PathVariable(name = "id") Long postid,@RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(updatePostRequest,postid);
        return PostResponse.createInstance(postService.findById(postid));
    }

    @DeleteMapping("/api/post/{id}")
    public Object postDelete(@PathVariable(name = "id") Long postId) {
        postService.delete(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
