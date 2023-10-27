package com.example.ecotag.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentFormVO {

    private long postId;
    private String userId;
    private String commentDetail;
    private long commentId;

}
