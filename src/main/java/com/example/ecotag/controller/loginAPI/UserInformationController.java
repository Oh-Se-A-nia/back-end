package com.example.ecotag.controller.loginAPI;

import com.example.ecotag.domain.user.SignUpFormVO;
import com.example.ecotag.entity.Trash;
import com.example.ecotag.entity.User;
import com.example.ecotag.service.user.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "회원가입 API")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserInformationController {

    private final UserService userService;

    @Parameter(name = "accessToken", description="카카오 api를 사용해 발급받은 회원의 accessToken")
    @PostMapping("/sign_in")
    public ResponseEntity<User> successLogin(@RequestParam String accessToken) {
        return userService.signIn(accessToken);
    }

    @PostMapping("/sign_up")
    public ResponseEntity<User> successSignUp(@RequestBody SignUpFormVO signUpFormVO) {
        return userService.signUp(signUpFormVO);
    }
}
