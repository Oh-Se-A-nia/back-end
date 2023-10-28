package com.example.ecotag.domain.contribution;

import com.example.ecotag.entity.User;
import com.example.ecotag.entity.UserContribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserContributionRepository extends JpaRepository<UserContribution, Long> {
}
