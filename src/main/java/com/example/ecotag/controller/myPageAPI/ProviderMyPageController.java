package com.example.ecotag.controller.myPageAPI;

import com.example.ecotag.domain.myPage.MyPageFormVO;
import com.example.ecotag.entity.MyPage;
import com.example.ecotag.service.myPage.MyPageService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/my_page")
@RequiredArgsConstructor
public class ProviderMyPageController {

    private final MyPageService myPageService;

    @Tag(name="MyPage API")
    @GetMapping
    public ResponseEntity<MyPage> provideMyPage(@RequestBody MyPageFormVO myPageFormVO) {
        return myPageService.classifyType(myPageFormVO);
    }
}
