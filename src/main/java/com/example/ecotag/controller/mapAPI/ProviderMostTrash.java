package com.example.ecotag.controller.mapAPI;

import com.example.ecotag.entity.Trash;
import com.example.ecotag.service.trash.TrashService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Map API", description = "지도 메뉴에서 쓰레기 정보를 제공해 주는 API")
@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class ProviderMostTrash {

    private final TrashService trashService;

    @Parameter(name = "location", description = "가장 많은 쓰레기 타입을 알고 싶은 지역명")
    @GetMapping("/most_trash/{location}")
    public ResponseEntity returnTrashType(@PathVariable("location") String location) {
        return trashService.returnMostTrash(location);
    }

}