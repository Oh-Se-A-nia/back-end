package com.example.ecotag.domain.trash;

import com.example.ecotag.entity.Trash;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrashVO {

    @ApiModelProperty(value = "글에 해당하는 쓰레기의 사진", required = true)
    private String trashPicture;

    @ApiModelProperty(value = "글에 해당하는 쓰레기의 위치", required = true)
    private String trashLocation;

    @ApiModelProperty(value = "글에 해당하는 쓰레기의 타입", required = true)
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
