package com.example.ecotag.service.contribution;

import com.example.ecotag.domain.post.PostingFormVO;

public interface ContributionService {

    boolean pushUserPostingContribution(String userId);

    boolean pushUserCommentContribution(String userId);

}
