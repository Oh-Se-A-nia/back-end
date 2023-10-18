package com.example.ecotag.controller.communityAPI;

import com.example.ecotag.domain.post.PostingFormVO;
import com.example.ecotag.service.post.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Post API", description = "글을 작성하도록 하는 API")
@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class PostingController {

    private final PostService postService;

    @PostMapping("/uploading")
    public ResponseEntity posting(@RequestBody PostingFormVO postingFormVO){
        return postService.post(postingFormVO);
    }
}
