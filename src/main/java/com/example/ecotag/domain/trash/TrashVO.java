package com.example.ecotag.domain.trash;

import com.example.ecotag.entity.Trash;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrashVO {

    private String trashPicture;
    private String trashLocation;
    private String trashType;


    public Trash toEntity() {
        Trash trash = Trash.builder()
                .trashLocation(trashLocation)
                .trashType(trashType)
                .trashPicture(trashPicture)
                .build();

        return trash;
    }
}
