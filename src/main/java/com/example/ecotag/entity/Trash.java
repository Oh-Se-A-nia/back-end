package com.example.ecotag.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Table(name = "trashes")
@Builder
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Trash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Lob
    private String trashPicture;

    private String trashLocation;

    private String trashType;

}