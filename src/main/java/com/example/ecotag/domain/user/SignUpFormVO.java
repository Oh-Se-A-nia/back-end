package com.example.ecotag.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpFormVO {

    private String accessToken;
    private String userId;
    private String nickname;
    private byte[] profile;

}
