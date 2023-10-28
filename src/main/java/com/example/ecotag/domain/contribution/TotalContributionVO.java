package com.example.ecotag.domain.contribution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TotalContributionVO {

    private long totalPicture;
    private long myPicture;
    private long totalComment;
    private long myComment;

}
