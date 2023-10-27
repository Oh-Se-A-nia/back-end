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

@Tag(name = "Community API", description = "커뮤니티 메뉴에서 사용하는 API")
@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @Parameter(name = "글 작성 API", description = "사진을 찍어 쓰레기 사진, 쓰레기 타입, 쓰레기 장소를 저장해 글을 쓰는 API")
    @PostMapping("/uploading/posting")
    public ResponseEntity<String> posting(@RequestBody PostingFormVO postingFormVO){
        return communityService.post(postingFormVO);
    }

    @Parameter(name = "전체 글 목록 조회 API", description = "커뮤니티 메뉴에서 전체 글을 조회하는 API")
    @GetMapping("/posting_list")
    public ResponseEntity<TotalPostingListVO> returnTotalPosting() {
        return communityService.providePostingList();
    }

    @Parameter(name = "글 상세 조회 API", description = "글의 상세 내용을 확인하는 API")
    @GetMapping("/detail_post/{post_id}")
    public ResponseEntity<PostDetailVO> returnDetailPosting(@PathVariable("post_id") long postId) {
        return communityService.providePostingDetail(postId);
    }

    @Parameter(name = "댓글 작성 API", description = "하나의 글에 댓글을 작성하는 API")
    @GetMapping("/uploading/comment")
    public ResponseEntity putComment(CommentFormVO commentFormVO) {
        return communityService.putComment(commentFormVO);
    }
}
