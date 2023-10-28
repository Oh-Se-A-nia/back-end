package com.example.ecotag.domain.user;

import com.example.ecotag.entity.Trash;
import com.example.ecotag.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpFormVO {

    private String accessToken;
    private String userId;
    private String nickname;
    private String profile;

}
