package com.example.ecotag.controller.communityAPI;

import com.example.ecotag.domain.comment.CommentFormVO;
import com.example.ecotag.domain.community.PostDetailVO;
import com.example.ecotag.domain.community.PostingFormVO;
import com.example.ecotag.domain.community.TotalPostingListVO;
import com.example.ecotag.service.community.CommunityService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @Tag(name = "글 작성 API")
    @PostMapping("/uploading/posting")
    public ResponseEntity<String> posting(@RequestBody PostingFormVO postingFormVO) {
        return communityService.post(postingFormVO);
    }

    @Tag(name = "글 전체 조회 API")
    @GetMapping("/posting_list")
    public ResponseEntity<TotalPostingListVO> returnTotalPosting() {
        return communityService.providePostingList();
    }

    @Tag(name = "글 상세 조회 API")
    @Parameter(name = "post id", description = "조회하고자 하는 post의 id")
    @GetMapping("/detail_post/{post_id}")
    public ResponseEntity<PostDetailVO> returnDetailPosting(@PathVariable("post_id") long postId) {
        return communityService.providePostingDetail(postId);
    }

    @Tag(name = "댓글 작성 API")
    @PostMapping("/uploading/comment")
    public ResponseEntity putComment(@RequestBody CommentFormVO commentFormVO) {
        return communityService.putComment(commentFormVO);
    }

    @Tag(name = "좋아요 API")
    @Parameter(name = "comment id", description = "좋아요를 남길 댓글의 id")
    @GetMapping("/likes/{comment_id}")
    public ResponseEntity putCommentLikes(@PathVariable("comment_id") long commentId) {
        return communityService.countCommentLikes(commentId);
    }
}
