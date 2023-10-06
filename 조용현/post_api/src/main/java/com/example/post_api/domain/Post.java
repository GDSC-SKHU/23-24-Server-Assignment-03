package com.example.post_api.domain;

import com.example.post_api.post.dto.UpdatePostRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_num")
    private Long id;

    //제목
    @Column(length = 500)
    private String title;

    //텍스트
    @Column(name = "post_content")
    @Lob
    private String content;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void UpdateValidate(UpdatePostRequest updatePostRequest) {
        this.title = updatePostRequest.getTitle();
        this.content = updatePostRequest.getContent();
    }
}
