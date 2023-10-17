package com.example.ecotag.model;

import lombok.Getter;

import java.sql.Blob;

@Getter
public class UserVO {

    private String accessToken;
    private String id;
    private String nickname;
    private Blob profile;

}
