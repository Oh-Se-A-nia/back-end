package com.example.ecotag.service.trash;

import com.example.ecotag.domain.trash.TrashRepository;
import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.entity.Trash;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrashServiceImpl implements TrashService{

    private final TrashRepository trashRepository;

    @Override
    public ResponseEntity findMostTrash(String location) {
        List<Trash> mostTrashByLocation = trashRepository.findbyLocation(location);
    }
}
