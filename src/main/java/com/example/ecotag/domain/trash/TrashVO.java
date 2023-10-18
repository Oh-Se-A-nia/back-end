package com.example.ecotag.domain.trash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrashVO {

    private long trashId;
    private byte[] trashPicture;
    private String trashLocation;
    private String trashType;

}
