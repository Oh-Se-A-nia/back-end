package com.example.ecotag.controller.contributionAPI;

import com.example.ecotag.domain.contribution.TotalContributionVO;
import com.example.ecotag.service.contribution.ContributionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Contribution API", description = "기여도 메뉴 관련 서비스")
@RestController
@RequestMapping("/api/contribution")
@RequiredArgsConstructor
public class ProviderContributionController {

    private final ContributionService contributionService;

    @ApiOperation(value = "기여도 API", notes = "로그인 되어 있는 유저의 기여도 정보 제공")
    @GetMapping("/{user_id}")
    public ResponseEntity<TotalContributionVO> returnContributionData(@PathVariable("user_id") String userId) {
        System.out.printf("user id is %s", userId);
        return contributionService.provideTotalContribution(userId);
    }

}
