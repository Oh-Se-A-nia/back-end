package com.example.ecotag.domain.user;

import com.example.ecotag.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
