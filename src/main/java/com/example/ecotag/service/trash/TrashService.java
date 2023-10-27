package com.example.ecotag.service.trash;

import com.example.ecotag.domain.trash.TrashVO;
import org.springframework.http.ResponseEntity;

public interface TrashService {
    ResponseEntity findMostTrash(String location);
}
