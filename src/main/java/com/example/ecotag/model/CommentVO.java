package com.example.ecotag.model;

import lombok.Getter;

@Getter
public class CommentVO {

    private int id;
    private String userId;
    private int postId;
    private String detail;
    private String creationTime;
    private int likes;

}
