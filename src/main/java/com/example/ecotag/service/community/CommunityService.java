package com.example.ecotag.service.community;

import com.example.ecotag.domain.community.CommentFormVO;
import com.example.ecotag.domain.community.PostDetailVO;
import com.example.ecotag.domain.community.PostingFormVO;
import com.example.ecotag.domain.community.TotalPostingListVO;
import org.springframework.http.ResponseEntity;

public interface CommunityService {

    ResponseEntity post(PostingFormVO postingFormVO);

    ResponseEntity providePostingList();

    ResponseEntity providePostingDetail(long postId);
    ResponseEntity putComment(CommentFormVO commentFormVO);

}
