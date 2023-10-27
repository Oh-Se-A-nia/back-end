package com.example.ecotag.service.community;

import com.example.ecotag.domain.comment.CommentFormVO;
import com.example.ecotag.domain.comment.CommentRepository;
import com.example.ecotag.domain.community.*;
import com.example.ecotag.domain.trash.TrashVO;
import com.example.ecotag.domain.user.UserInformationVO;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.Comment;
import com.example.ecotag.entity.Post;
import com.example.ecotag.entity.Trash;
import com.example.ecotag.entity.User;
import com.example.ecotag.service.contribution.ContributionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final UserRepository userRepository;
    private final ContributionServiceImpl contributionService;
    private final CommentRepository commentRepository;

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

                if (!contributionService.pushUserPostingContribution(postingFormVO.getUserId())) {
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
    public ResponseEntity providePostingList() {
        Optional<List<Post>> posts = Optional.ofNullable(communityRepository.findAll());

        List<TotalPostingListVO> postList = new ArrayList<>();
        TotalPostingListVO onePost;

        if (posts.isPresent()) {
            for (Post post : posts.get()) {
                onePost = new TotalPostingListVO(post.getId(),
                        post.getPostTrash().getTrashPicture(),
                        post.getPostTrash().getTrashType(),
                        post.getPostTrash().getTrashLocation());

                postList.add(onePost);
            }

        } else {
            return new ResponseEntity("post is empty", HttpStatus.OK);
        }

        return new ResponseEntity(postList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity providePostingDetail(long postId) {
        Optional<Post> post = communityRepository.findById(postId);

        if (post.isPresent()) {

            UserInformationVO postingUser = changeUserEntityForm(post.get().getPostUser());
            TrashVO postedTrash = changeTrashEntityForm(post.get().getPostTrash());
            List<CommentFormVO> comments = changeCommentEntityForm(commentRepository.findByPostId(postId));

            PostDetailVO postDetail = new PostDetailVO(postId,
                    post.get().getPostDetail(), postedTrash,
                    postingUser, comments);

            return new ResponseEntity(postDetail, HttpStatus.OK);

        } else {
            return new ResponseEntity("post is not exist, check one more post id", HttpStatus.BAD_REQUEST);
        }
    }

    private UserInformationVO changeUserEntityForm(User userEntity) {
        return new UserInformationVO(userEntity.getUserId(),
                userEntity.getNickname(), userEntity.getProfile());
    }

    private TrashVO changeTrashEntityForm(Trash trashEntity) {
        return new TrashVO(trashEntity.getTrashPicture(),
                trashEntity.getTrashLocation(), trashEntity.getTrashType());
    }

    private List<CommentFormVO> changeCommentEntityForm(List<Comment> comments) {
        List<CommentFormVO> commentList = new ArrayList<>();

        for (Comment comment : comments) {
            CommentFormVO oneComment = new CommentFormVO(comment.getPost().getId(),
                    comment.getUser().getUserId(), comment.getDetail(), comment.getId());

            commentList.add(oneComment);
        }

        return commentList;
    }

    @Override
    public ResponseEntity putComment(CommentFormVO commentFormVO) {
        Optional<User> user = userRepository.findById(commentFormVO.getUserId());
        Optional<Post> post = communityRepository.findById(commentFormVO.getPostId());

        if (user.isPresent() && post.isPresent()) {
            Optional<Comment> comment = Optional.ofNullable(Comment.builder()
                    .detail(commentFormVO.getCommentDetail())
                    .user(user.get())
                    .post(post.get())
                    .build());

            if (comment.isPresent()) {
                commentRepository.save(comment.get());
                contributionService.pushUserCommentContribution(commentFormVO.getUserId());

            } else {
                return new ResponseEntity("comment detail value is invalidation", HttpStatus.BAD_REQUEST);
            }

        } else {
            return new ResponseEntity("user id or post id is invalidation", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity countCommentLikes(long commentId) {
        //Optional<Comment> comment = commentRepository.findById(commentId);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("comment not found"));

        comment.setLikes(comment.getLikes() + 1);

        return new ResponseEntity("success", HttpStatus.OK);
    }
}