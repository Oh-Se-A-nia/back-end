package com.example.ecotag.domain.post;


import com.example.ecotag.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
