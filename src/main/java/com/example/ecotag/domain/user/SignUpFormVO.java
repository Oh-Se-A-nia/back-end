package com.example.ecotag.domain.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpFormVO {

    @ApiModelProperty(value = "로그인을 유지하게 해 주는 access token", required = true)
    private String accessToken;

    @ApiModelProperty(value = "로그인한 유저의 아이디", required = true)
    private String userId;

    @ApiModelProperty(value = "로그인한 유저의 닉네임", required = true)
    private String nickname;

    @ApiModelProperty(value = "로그인한 유저의 프로필 사진", required = true)
    private String profile;

}
