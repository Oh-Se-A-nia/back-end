package com.example.ecotag.service.contribution;


import com.example.ecotag.domain.contribution.TotalContributionVO;
import org.springframework.http.ResponseEntity;

public interface ContributionService {

    boolean pushUserPostingContribution(String userId);

    boolean pushUserCommentContribution(String userId);

    ResponseEntity<TotalContributionVO> provideTotalContribution(String userId);

}
