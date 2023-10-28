package com.example.ecotag.service.community;

import com.example.ecotag.domain.comment.CommentFormVO;
import com.example.ecotag.domain.community.PostingFormVO;
import org.springframework.http.ResponseEntity;

public interface CommunityService {

    ResponseEntity post(PostingFormVO postingFormVO);

    ResponseEntity providePostingList();

    ResponseEntity providePostingDetail(long postId);
    ResponseEntity putComment(CommentFormVO commentFormVO);

    ResponseEntity countCommentLikes(long commentId);

}
