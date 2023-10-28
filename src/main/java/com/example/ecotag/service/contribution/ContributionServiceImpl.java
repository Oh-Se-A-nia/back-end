package com.example.ecotag.service.contribution;

import com.example.ecotag.domain.contribution.TotalContributionVO;
import com.example.ecotag.domain.contribution.UserContributionRepository;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.User;
import com.example.ecotag.entity.UserContribution;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {

    private final UserRepository userRepository;
    private final UserContributionRepository userContributionRepository;


    @Override
    public boolean pushUserPostingContribution(String userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            Optional<UserContribution> userContribution = Optional.ofNullable(UserContribution.builder()
                    .userId(user.get())
                    .postingCount(1)
                    .build());

            if (userContribution.isPresent()) {
                userContributionRepository.save(userContribution.get());
            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public boolean pushUserCommentContribution(String userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            Optional<UserContribution> userContribution = Optional.ofNullable(UserContribution.builder()
                    .userId(user.get())
                    .commentCount(1)
                    .build());

            if (userContribution.isPresent()) {
                userContributionRepository.save(userContribution.get());
            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public ResponseEntity<TotalContributionVO> provideTotalContribution(String userId) {
        List<UserContribution> contribution = userContributionRepository.findAll();
        Optional<User> user = userRepository.findById(userId);

        long totalPicture = (contribution.stream()
                .filter(userContribution -> userContribution.getCommentCount() == 0)
                .count());

        long myPicture = (contribution.stream()
                .filter(userContribution -> userContribution.getCommentCount() == 0
                        && userContribution.getUserId().equals(user.get()))
                .count());

        long totalComment = (contribution.stream()
                .filter(userContribution -> userContribution.getPostingCount() == 0)
                .count());

        long myComment = (contribution.stream()
                .filter(userContribution -> userContribution.getPostingCount() == 0
                        && userContribution.getUserId().equals(user.get()))
                .count());

        TotalContributionVO totalContribution =
                new TotalContributionVO(totalPicture, myPicture, totalComment, myComment);

        return new ResponseEntity<>(totalContribution, HttpStatus.OK);
    }
}
