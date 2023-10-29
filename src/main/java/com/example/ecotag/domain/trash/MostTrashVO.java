package com.example.ecotag.domain.trash;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MostTrashVO {

    @ApiModelProperty(value = "가장 많이 발견된 쓰레기의 타입", required = true)
    private String mostCommonTrashType;

}
