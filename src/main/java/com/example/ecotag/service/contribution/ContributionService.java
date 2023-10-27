package com.example.ecotag.service.contribution;


public interface ContributionService {

    boolean pushUserPostingContribution(String userId);

    boolean pushUserCommentContribution(String userId);

}
