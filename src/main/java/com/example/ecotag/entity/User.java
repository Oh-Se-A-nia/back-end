package com.example.ecotag.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Table(name = "users")
@Builder
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Column(name = "access_token")
    private String accessToken;

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    private String nickname;

    @Lob
    private String profile;

    public User() {

    }
}
