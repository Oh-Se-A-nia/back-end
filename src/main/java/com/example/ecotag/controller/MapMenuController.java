package com.example.ecotag.controller;

import com.example.ecotag.model.TrashVO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Map API", description = "지도 메뉴에서 쓰레기 정보를 제공해 주는 API")
@RestController
@RequestMapping("/api/map")
public class MapMenuController {

    private TrashVO trashVO;

    @Parameter(name = "location", description = "가장 많은 쓰레기 타입을 알고 싶은 지역명")
    @GetMapping("/map/most_trash/{location}")
    public ResponseEntity<TrashVO> returnTrashType(@RequestParam String location) {
        trashVO = findTrashType(location);

        return ResponseEntity.ok()
                .body(trashVO);
    }

    private TrashVO findTrashType(String location) {
        return trashVO;
    }

}