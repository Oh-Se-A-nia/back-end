package com.example.ecotag.domain.trash;

import com.example.ecotag.entity.Trash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrashRepository extends JpaRepository<Trash, Integer> {
    List<Trash> findbyLocation(String location);
}
