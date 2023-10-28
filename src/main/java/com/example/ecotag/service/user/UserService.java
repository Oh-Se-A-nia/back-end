package com.example.ecotag.service.user;

import com.example.ecotag.domain.user.SignUpFormVO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity signUp(SignUpFormVO signUpFormVO);
    ResponseEntity signIn(String accessToken);
}
