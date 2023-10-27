package com.example.ecotag.service.user;

import com.example.ecotag.domain.user.SignUpFormVO;
import com.example.ecotag.domain.user.UserRepository;
import com.example.ecotag.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public ResponseEntity signUp(SignUpFormVO signUpFormVO) {
        return null;
    }

    @Override
    public ResponseEntity signIn(String accessToken) {
        Optional<User> user = userRepository.findById(accessToken);

        if()
    }

}
