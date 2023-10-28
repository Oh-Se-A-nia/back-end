package com.example.ecotag.service.myPage;

import com.example.ecotag.domain.comment.CommentRepository;
import com.example.ecotag.domain.community.CommunityRepository;
import com.example.ecotag.domain.community.TotalPostingListVO;
import com.example.ecotag.domain.myPage.MyPageFormVO;
import com.example.ecotag.domain.trash.TrashRepository;
import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.Comment;
import com.example.ecotag.entity.Post;
import com.example.ecotag.entity.Trash;
import com.example.ecotag.entity.User;
import com.example.ecotag.service.trash.TrashService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {

    private MyPageFormVO myPage;
    private final TrashRepository trashRepository;
    private final CommunityRepository communityRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity classifyType(MyPageFormVO myPageFormVO) {
        myPage = myPageFormVO;

        String type = myPageFormVO.getType();

        switch (type) {
            case "댓글":
                return provideRecentComment();
            case "사진":
                return providerRecentPicture();
            default:
                return new ResponseEntity("type is invaild value", HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity provideRecentComment() {
        List<Comment> commentList = commentRepository.findAll();
        Optional<User> user = userRepository.findById(myPage.getUserId());

        if (commentList.isEmpty()) {
            return new ResponseEntity("this user's active is notting", HttpStatus.OK);
        }
        if (!user.isPresent()) {
            return new ResponseEntity("user id is invaild data", HttpStatus.BAD_REQUEST);
        }

        commentList = commentList.stream()
                .filter(comment -> comment.getUser().equals(user.get()))
                .sorted(Comparator.comparing(comment -> comment.getCreationTime(), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<TotalPostingListVO> posts = new ArrayList<>();
        List<Long> postId = new ArrayList<>();

        for (Comment comment : commentList) {
            Post postWithComment = comment.getPost();
            if (postId.contains(postWithComment.getId())) {
                continue;
            }

            Trash trashOfPost = postWithComment.getPostTrash();

            TotalPostingListVO post = new TotalPostingListVO(postWithComment.getId(),
                    trashOfPost.getTrashPicture(), trashOfPost.getTrashType(), trashOfPost.getTrashLocation());


            posts.add(post);
            postId.add(postWithComment.getId());
        }

        return new ResponseEntity(posts, HttpStatus.OK);
    }

    private ResponseEntity providerRecentPicture() {
        List<Post> postList = communityRepository.findAll();
        Optional<User> user = userRepository.findById(myPage.getUserId());

        if (postList.isEmpty()) {
            return new ResponseEntity("this user's active is notting", HttpStatus.OK);
        }
        if (!user.isPresent()) {
            return new ResponseEntity("user id is invaild data", HttpStatus.BAD_REQUEST);
        }

        postList = postList.stream()
                .filter(post -> post.getPostUser().equals(user.get()))
                .sorted(Comparator.comparing(post -> post.getCreationTime(), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<TrashVO> trashes = new ArrayList<>();

        for (Post post : postList) {
            Trash trashEntity = post.getPostTrash();
            TrashVO trash = new TrashVO(trashEntity.getTrashPicture(),
                    trashEntity.getTrashLocation(), trashEntity.getTrashType());

            trashes.add(trash);
        }

        return new ResponseEntity(trashes, HttpStatus.OK);
    }
}
