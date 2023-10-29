package com.example.ecotag.domain.community;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TotalPostingListVO {

    @ApiModelProperty(value = "게시 글에 할당된 아이디 : pk", required = true)
    private long postId;

    @ApiModelProperty(value = "글에 해당하는 쓰레기의 사진", required = true)
    private String postPicture;

    @ApiModelProperty(value = "글에 해당하는 쓰레기의 타입", required = true)
    private String trashType;

    @ApiModelProperty(value = "글에 해당하는 쓰레기의 위치 정보", required = true)
    private String trashLocation;

}
