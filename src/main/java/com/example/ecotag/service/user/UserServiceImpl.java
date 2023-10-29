package com.example.ecotag.service.user;

import com.example.ecotag.domain.user.SignUpFormVO;
import com.example.ecotag.domain.user.UserRepository;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity signUp(SignUpFormVO signUpFormVO) {
        Optional<User> user = Optional.ofNullable(userRepository.findByAccessToken(signUpFormVO.getAccessToken()));
        Optional<User> signUpUser = null;

        if (!user.isPresent()) {
            signUpUser = Optional.ofNullable(User.builder()
                    .userId(signUpFormVO.getUserId())
                    .nickname(signUpFormVO.getNickname())
                    .accessToken(signUpFormVO.getAccessToken())
                    .profile(signUpFormVO.getProfile())
                    .build());

        }
        if (signUpUser.isPresent()) {
            userRepository.save(signUpUser.get());
            return signIn(signUpUser.get().getUserId());
        } else {
            return new ResponseEntity("sign up is fail", HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity signIn(String userId) {
        Optional<User> user = userRepository.findById(userId);
        User foundUser = user.get();

        if (user != null) {
            SignUpFormVO userInformation = new SignUpFormVO(foundUser.getAccessToken(),
                    foundUser.getUserId(), foundUser.getNickname(), foundUser.getProfile());

            return new ResponseEntity(userInformation, HttpStatus.OK);
        } else {
            return new ResponseEntity("user is not exist", HttpStatus.BAD_REQUEST);
        }
    }

}
