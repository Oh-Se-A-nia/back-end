package com.example.ecotag.controller.userInformationAPI;

import com.example.ecotag.domain.user.SignInFormVO;
import com.example.ecotag.domain.user.SignUpFormVO;
import com.example.ecotag.entity.User;
import com.example.ecotag.service.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserInformationController {

    private final UserService userService;

    @Tag(name = "로그인 API")
    @PostMapping("/sign_in")
    public ResponseEntity<User> successLogin(@RequestBody SignInFormVO signInFormVO) {
        return userService.signIn(signInFormVO.getAccessToken());
    }

    @Tag(name = "회원가입 API")
    @PostMapping("/sign_up")
    public ResponseEntity<User> successSignUp(@RequestBody SignUpFormVO signUpFormVO) {
        return userService.signUp(signUpFormVO);
    }
}
