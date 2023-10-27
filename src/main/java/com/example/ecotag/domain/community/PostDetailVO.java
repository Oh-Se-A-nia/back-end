package com.example.ecotag.domain.community;

import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.domain.user.UserInformationVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailVO {

    private long postId;
    private String postDetail;
    private TrashVO trash;
    private UserInformationVO user;
    private ArrayList<CommentFormVO> comments;

}