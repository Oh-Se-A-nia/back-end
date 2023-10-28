package com.example.ecotag.controller.contributionAPI;

import com.example.ecotag.domain.contribution.TotalContributionVO;
import com.example.ecotag.service.contribution.ContributionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contribution")
@RequiredArgsConstructor
public class ProviderContributionController {

    private final ContributionService contributionService;

    @Tag(name="기여도를 확인하는 API")
    @Parameter(name = "user id", description = "현재 로그인해 있는 유저의 id")
    @GetMapping("/{user_id}")
    public ResponseEntity<TotalContributionVO> returnContributionData(@PathVariable("user_id") String userId) {
        System.out.printf("user id is %s", userId);
        return contributionService.provideTotalContribution(userId);
    }

}
