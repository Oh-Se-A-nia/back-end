package com.example.ecotag.service.trash;

import org.springframework.http.ResponseEntity;

public interface TrashService {
    ResponseEntity returnMostTrash(String location);
}
