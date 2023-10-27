package com.example.ecotag.domain.community;


import com.example.ecotag.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommunityRepository extends JpaRepository<Post, Long> {
}
