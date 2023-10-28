package com.example.ecotag.service.myPage;

import com.example.ecotag.domain.myPage.MyPageFormVO;
import org.springframework.http.ResponseEntity;

public interface MyPageService {
    public ResponseEntity classifyType(MyPageFormVO myPageFormVO);
}
