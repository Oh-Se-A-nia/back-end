package com.example.ecotag.domain.contribution;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TotalContributionVO {

    @ApiModelProperty(value = "전체 글의 수", required = true)
    private long totalPicture;

    @ApiModelProperty(value = "자신이 작성한 글의 수", required = true)
    private long myPicture;

    @ApiModelProperty(value = "댓글 수", required = true)
    private long totalComment;

    @ApiModelProperty(value = "자신이 해결한 문제의 수", required = true)
    private long myComment;

}
