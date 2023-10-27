package com.example.ecotag.service.trash;

import com.example.ecotag.domain.trash.MostTrashTypeCountingDTO;
import com.example.ecotag.domain.trash.MostTrashVO;
import com.example.ecotag.domain.trash.TrashRepository;
import com.example.ecotag.entity.Trash;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrashServiceImpl implements TrashService {

    private MostTrashVO mostTrashVO;
    private final TrashRepository trashRepository;
    private List<Trash> mostTrashByLocation;
    private MostTrashTypeCountingDTO mostTrash = new MostTrashTypeCountingDTO();

    @Override
    public ResponseEntity returnMostTrash(String location) {
        mostTrashByLocation = trashRepository.findByTrashLocation(location);

        if (mostTrashByLocation.isEmpty()) {
            return new ResponseEntity("location is not exist", HttpStatus.BAD_REQUEST);
        }

        String mostTrashType = findMostTrash();

        if (mostTrashType == null) {
            return new ResponseEntity("trash is not exist", HttpStatus.BAD_REQUEST);
        }

        mostTrashVO = new MostTrashVO(mostTrashType);

        return new ResponseEntity(mostTrashVO, HttpStatus.OK);

    }

    private String findMostTrash() {
        classifyTrashType();

        String mostCommonType = "담배꽁초";
        int maxCount = mostTrash.getCigaretteCount();

        if (mostTrash.getDisposableCount() > maxCount) {
            mostCommonType = "일회용컵";
            maxCount = mostTrash.getDisposableCount();
        }
        if (mostTrash.getMaskCount() > maxCount) {
            mostCommonType = "마스크";
            maxCount = mostTrash.getMaskCount();
        }
        if (mostTrash.getFoodWasteCount() > maxCount) {
            mostCommonType = "음식물 쓰레기";
            maxCount = mostTrash.getFoodWasteCount();
        }
        if (mostTrash.getIllegalDumpingCount() > maxCount) {
            mostCommonType = "무단 쓰레기";
            maxCount = mostTrash.getIllegalDumpingCount();
        }

        return mostCommonType;
    }

    private void classifyTrashType() {
        String type;

        for (Trash trash:mostTrashByLocation) {
            type = trash.getTrashType();

            switch (type) {
                case "담배꽁초":
                    mostTrash.setCigaretteCount(mostTrash.getCigaretteCount() + 1);
                    System.out.printf("담배꽁초 추가!\n");
                    break;
                case "마스크":
                    mostTrash.setMaskCount(mostTrash.getMaskCount() + 1);
                    System.out.printf("마스크 추가!\n");
                    break;
                case "일회용컵":
                    mostTrash.setDisposableCount(mostTrash.getDisposableCount() + 1);
                    System.out.printf("일회용컵 추가!\n");
                    break;
                case "무단 쓰레기":
                    mostTrash.setIllegalDumpingCount(mostTrash.getIllegalDumpingCount() + 1);
                    System.out.printf("무단 쓰레기 추가!\n");
                    break;
                case "음식물 쓰레기":
                    mostTrash.setFoodWasteCount(mostTrash.getFoodWasteCount() + 1);
                    System.out.printf("음식물 쓰레기 추가!\n");
                    break;
                default:
                    System.out.printf("맞는 값이 업어요\n");
                    break;
            }
        }
    }
}
