package com.example.ecotag.controller.communityAPI;

import com.example.ecotag.domain.comment.CommentFormVO;
import com.example.ecotag.domain.community.PostDetailVO;
import com.example.ecotag.domain.community.PostingFormVO;
import com.example.ecotag.domain.community.TotalPostingListVO;
import com.example.ecotag.service.community.CommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Community API"}, description = "커뮤니티 메뉴 관련 서비스")
@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @ApiOperation(value = "글 작성")
    @PostMapping("/uploading/posting")
    public ResponseEntity<String> posting(@RequestBody PostingFormVO postingFormVO) {
        return communityService.post(postingFormVO);
    }

    @ApiOperation(value = "전체 글 조회", notes = "커뮤니티 메뉴 메인 창에서 전체 게시 글을 조회하도록 하는 서비스")
    @GetMapping("/posting_list")
    public ResponseEntity<TotalPostingListVO> returnTotalPosting() {
        return communityService.providePostingList();
    }

    @ApiOperation(value = "상세 글 조회", notes = "선택한 글을 상세 보기 하는 서비스")
    @GetMapping("/detail_post/{post_id}")
    public ResponseEntity<PostDetailVO> returnDetailPosting(@PathVariable("post_id") long postId) {
        return communityService.providePostingDetail(postId);
    }

    @ApiOperation(value = "댓글 작성")
    @PostMapping("/uploading/comment")
    public ResponseEntity putComment(@RequestBody CommentFormVO commentFormVO) {
        return communityService.putComment(commentFormVO);
    }

    @ApiOperation(value = "좋아요", notes = "댓글에 좋아요를 남길 수 있도록 돕는 서비스")
    @GetMapping("/likes/{comment_id}")
    public ResponseEntity putCommentLikes(@PathVariable("comment_id") long commentId) {
        return communityService.countCommentLikes(commentId);
    }

}
