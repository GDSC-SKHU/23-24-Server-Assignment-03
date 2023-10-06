package com.example.post_api.post.service;

import com.example.post_api.domain.Post;
import com.example.post_api.post.dto.AddPostRequest;
import com.example.post_api.post.dto.UpdatePostRequest;
import com.example.post_api.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post savePost(AddPostRequest addPostRequest){
        return postRepository.save(addPostRequest.toEntity());
    }

    public List<Post> findAll() {return postRepository.findAll();}

    public Post findById(Long postId) {return postRepository.findById(postId).get();}

    @Transactional
    public void updatePost(UpdatePostRequest upPost, Long postId) {
        Post findPost = findById(postId);
        postRepository.update(upPost, findPost);
    }

    @Transactional
    public void delete(Long postId) {
        Post findPost = findById(postId);
        postRepository.delete(findPost);
    }
}
