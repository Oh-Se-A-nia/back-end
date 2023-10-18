package com.example.ecotag.service.post;

import com.example.ecotag.domain.post.PostingFormVO;
import org.springframework.http.ResponseEntity;

public interface PostService {

    ResponseEntity post(PostingFormVO postingFormVO);
}
