package com.example.ecotag.model;

import lombok.Getter;

import java.sql.Blob;

@Getter
public class TrashVO {

    private int id;
    private Blob picture;
    private String location;
    private String type;

}
