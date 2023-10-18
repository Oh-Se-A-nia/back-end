package com.example.ecotag.service.post;

import com.example.ecotag.domain.post.PostRepository;
import com.example.ecotag.domain.post.PostingFormVO;
import com.example.ecotag.domain.trash.TrashRepository;
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


        /*Optional<Member> member = memberRepository.findById(formDTO.getId());

        if (member.isEmpty()) {
            Member newMember = Member.builder()
                    .id(formDTO.getId())
                    .password(formDTO.getPassword())
                    .name(formDTO.getName())
                    .role(MemberRole.USER)
                    .build();

            memberRepository.save(newMember);

            return new ResponseEntity("success", HttpStatus.OK);
        } else {
            return new ResponseEntity("fail", HttpStatus.OK);
        }*/
        Optional<User> user = userRepository.findById(postingFormVO.getUserId());

        if(user.isPresent()){
            Optional<Post> newPost = Optional.ofNullable(Post.builder()
                    .postDetail(postingFormVO.getPostDetail())
                    .postUser(user.get())
                    .postTrash(postingFormVO.getTrash())
                    .build());

            if(newPost.isPresent()){
                postRepository.save(newPost.get());
            } else {
                System.out.printf("post Fail");
            }
        } else {
            System.out.printf("user Fail");
        }

        return new ResponseEntity("success", HttpStatus.OK);
    }
}