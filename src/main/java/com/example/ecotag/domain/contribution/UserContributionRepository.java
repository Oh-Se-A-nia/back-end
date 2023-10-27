package com.example.ecotag.domain.contribution;

import com.example.ecotag.entity.User;
import com.example.ecotag.entity.UserContribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContributionRepository extends JpaRepository<UserContribution, User> {
}
