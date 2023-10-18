package com.example.ecotag.domain.trash;

import com.example.ecotag.entity.Trash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashRepository extends JpaRepository<Trash, Integer> {
}
