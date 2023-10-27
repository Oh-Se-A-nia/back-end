package com.example.ecotag.domain.community;


import com.example.ecotag.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommunityRepository extends JpaRepository<Post, Long> {
}
