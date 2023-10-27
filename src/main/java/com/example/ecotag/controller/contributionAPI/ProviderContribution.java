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

@Tag(name = "Contribution API", description = "전체 기여도와 자신의 기여도를 확인해 볼 수 있는 API")
@RestController
@RequestMapping("/api/contribution")
@RequiredArgsConstructor
public class ProviderContribution {

    private final ContributionService contributionService;

    @Parameter(name = "기여도 API", description = "전체 기여도, 유저의 기여도를 각각 제공하는 API")
    @GetMapping("/{user_id}")
    public ResponseEntity<TotalContributionVO> returnContributionData(@PathVariable("user_id") String userId) {
        return contributionService.provideTotalContribution(userId);
    }

}
