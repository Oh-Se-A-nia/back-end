package com.example.ecotag.controller.myPageAPI;

import com.example.ecotag.domain.myPage.MyPageFormVO;
import com.example.ecotag.entity.MyPage;
import com.example.ecotag.service.myPage.MyPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "My Page API")
@RestController
@RequestMapping("/api/my_page")
@RequiredArgsConstructor
public class ProviderMyPageController {

    private final MyPageService myPageService;

    @ApiOperation(value = "마이 페이지 API")
    @GetMapping
    public ResponseEntity<MyPage> provideMyPage(@RequestBody MyPageFormVO myPageFormVO) {
        return myPageService.classifyType(myPageFormVO);
    }
}
