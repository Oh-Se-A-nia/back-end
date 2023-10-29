package com.example.ecotag.domain.community;

import com.example.ecotag.domain.comment.CommentFormVO;
import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.domain.user.UserInformationVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailVO {

    @ApiModelProperty(value = "게시 글에 할당된 아이디 : pk", required = true)
    private long postId;

    @ApiModelProperty(value = "글 내용", required = true)
    private String postDetail;

    @ApiModelProperty(value = "글에 나와 있는 쓰레기 정보", required = true)
    private TrashVO trash;

    @ApiModelProperty(value = "글 작성자의 정보 객체", required = true)
    private UserInformationVO user;

    @ApiModelProperty(value = "댓글")
    private List<CommentFormVO> comments;

}
