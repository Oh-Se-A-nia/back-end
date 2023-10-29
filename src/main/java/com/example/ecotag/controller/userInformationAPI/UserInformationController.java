package com.example.ecotag.controller.userInformationAPI;

import com.example.ecotag.domain.user.SignUpFormVO;
import com.example.ecotag.entity.User;
import com.example.ecotag.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "User Info", description = "유저 정보 관련 API")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserInformationController {

    private final UserService userService;

    @ApiOperation(value = "회원 가입 및 로그인")
    @PostMapping("/sign_up")
    public ResponseEntity<User> successSignUp(@RequestBody SignUpFormVO signUpFormVO) {
        return userService.signUp(signUpFormVO);
    }

}
