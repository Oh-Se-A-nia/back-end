package com.example.ecotag.domain.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentFormVO {

    @ApiModelProperty(value = "게시 글에 할당된 아이디 : pk", required = true)
    private long postId;

    @ApiModelProperty(value = "글 작성자 아이디", required = true)
    private String userId;

    @ApiModelProperty(value = "글 내용", required = true)
    private String commentDetail;

}
