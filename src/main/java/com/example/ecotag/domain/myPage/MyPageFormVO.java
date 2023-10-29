package com.example.ecotag.domain.myPage;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyPageFormVO {

    @ApiModelProperty(value = "로그인되어 있는 유저의 아이디", required = true)
    private String userId;

    @ApiModelProperty(value = "마이페이지의 어느 경로로 위치해 있는지에 대한 정보", required = true)
    private String type;

}
