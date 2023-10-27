package com.example.ecotag.service.contribution;

import com.example.ecotag.domain.contribution.UserContributionRepository;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.User;
import com.example.ecotag.entity.UserContribution;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {

    private final UserRepository userRepository;
    private final UserContributionRepository userContributionRepository;


    @Override
    public void pushUserPostingContribution(String userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            Optional<UserContribution> userContribution = Optional.ofNullable(UserContribution.builder()
                    .userId(user.get())
                    .postingCount(1)
                    .build());

            if (userContribution.isPresent()) {
                userContributionRepository.save(userContribution.get());
            }
        }
    }
}
