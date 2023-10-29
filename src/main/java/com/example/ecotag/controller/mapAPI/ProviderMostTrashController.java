package com.example.ecotag.controller.mapAPI;

import com.example.ecotag.domain.trash.MostTrashVO;
import com.example.ecotag.service.trash.TrashService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Map API")
@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class ProviderMostTrashController {

    private final TrashService trashService;

    @ApiOperation(value = "지역별 쓰레기 정보 제공 API", notes = "입력한 지역에서 가장 많이 신고된 쓰레기 정보를 알려 준다")
    @GetMapping("/most_trash/{location}")
    public ResponseEntity<MostTrashVO> returnTrashType(@PathVariable("location") String location) {
        return trashService.returnMostTrash(location);
    }

}