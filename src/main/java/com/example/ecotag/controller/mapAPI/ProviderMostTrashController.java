package com.example.ecotag.controller.mapAPI;

import com.example.ecotag.domain.trash.MostTrashVO;
import com.example.ecotag.service.trash.TrashService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class ProviderMostTrashController {

    private final TrashService trashService;

    @Tag(name ="지역별 가장 많은 쓰레기를 알려 주는 API")
    @Parameter(name = "location", description = "가장 많은 쓰레기 타입을 알고 싶은 지역명")
    @GetMapping("/most_trash/{location}")
    public ResponseEntity<MostTrashVO> returnTrashType(@PathVariable("location") String location) {
        return trashService.returnMostTrash(location);
    }

}