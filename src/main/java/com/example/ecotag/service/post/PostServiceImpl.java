package com.example.ecotag.service.post;

import com.example.ecotag.domain.post.PostRepository;
import com.example.ecotag.domain.post.PostingFormVO;
import com.example.ecotag.domain.trash.TrashRepository;
import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.Post;
import com.example.ecotag.entity.Trash;
import com.example.ecotag.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TrashRepository trashRepository;

    @Override
    public ResponseEntity post(PostingFormVO postingFormVO) {
        Optional<User> user = userRepository.findById(postingFormVO.getUserId());

        if(user.isPresent()){
            Optional<Post> newPost = Optional.ofNullable(Post.builder()
                    .postDetail(postingFormVO.getPostDetail())
                    .postUser(user.get())
                    .postTrash(postingFormVO.getTrash().toEntity())
                    .build());

            if(newPost.isPresent()){
                postRepository.save(newPost.get());
            } else {
                return new ResponseEntity("post is empty", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("user is not present", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.OK);
    }
}