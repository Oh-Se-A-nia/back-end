package com.example.ecotag.domain.user;

import com.example.ecotag.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationVO {

    private String userId;
    private String nickname;
    private String profile;

}
