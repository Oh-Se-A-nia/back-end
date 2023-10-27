package com.example.ecotag.service.community;

import com.example.ecotag.domain.community.CommentFormVO;
import com.example.ecotag.domain.community.CommunityRepository;
import com.example.ecotag.domain.community.PostingFormVO;
import com.example.ecotag.domain.community.TotalPostingListVO;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.Post;
import com.example.ecotag.entity.User;
import com.example.ecotag.service.contribution.ContributionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final UserRepository userRepository;
    private final ContributionServiceImpl contributionService;

    @Override
    public ResponseEntity post(PostingFormVO postingFormVO) {
        Optional<User> user = userRepository.findById(postingFormVO.getUserId());

        if (user.isPresent()) {
            Optional<Post> newPost = Optional.ofNullable(Post.builder()
                    .postDetail(postingFormVO.getPostDetail())
                    .postUser(user.get())
                    .postTrash(postingFormVO.getTrash().toEntity())
                    .build());

            if (newPost.isPresent()) {
                communityRepository.save(newPost.get());

                if(!contributionService.pushUserPostingContribution(postingFormVO.getUserId())) {
                    return new ResponseEntity("contribution skill is unactive", HttpStatus.BAD_GATEWAY);
                }

            } else {
                return new ResponseEntity("post is empty", HttpStatus.BAD_GATEWAY);
            }
        } else {
            return new ResponseEntity("user is not present", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TotalPostingListVO> providePostingList() {
        return null;
    }

    @Override
    public ResponseEntity providePostingDetail(long postId) {
        return null;
    }

    @Override
    public ResponseEntity putComment(CommentFormVO commentFormVO) {
        return null;
    }
}