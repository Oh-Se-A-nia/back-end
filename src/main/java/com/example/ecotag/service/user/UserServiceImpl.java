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

        if (user.isPresent()) {
            return new ResponseEntity("user is already existance", HttpStatus.BAD_REQUEST);
        } else {
            Optional<User> signUpUser = Optional.ofNullable(User.builder()
                    .userId(signUpFormVO.getUserId())
                    .nickname(signUpFormVO.getNickname())
                    .accessToken(signUpFormVO.getAccessToken())
                    .profile(signUpFormVO.getProfile())
                    .build());

            if (signUpUser.isPresent()) {
                userRepository.save(signUpUser.get());
                return signIn(signUpUser.get().getAccessToken());
            } else {
                System.out.printf("%s %s %s %s\n", signUpFormVO.getUserId(), signUpFormVO.getNickname(), signUpFormVO.getAccessToken(), signUpFormVO.getProfile());
                return new ResponseEntity("sign up is fail", HttpStatus.CONFLICT);
            }
        }
    }

    @Override
    public ResponseEntity signIn(String accessToken) {
        User user = userRepository.findByAccessToken(accessToken);

        if (user != null) {
            SignUpFormVO userInformation = new SignUpFormVO(user.getAccessToken(),
                    user.getUserId(), user.getNickname(), user.getProfile());

            return new ResponseEntity(userInformation, HttpStatus.OK);
        } else {
            return new ResponseEntity("user is not exist", HttpStatus.BAD_REQUEST);
        }
    }

}
