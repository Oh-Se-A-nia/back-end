package com.example.ecotag.service.user;

import com.example.ecotag.domain.user.SignInFormVO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity signIn(SignInFormVO signInFormVO);
}
