package com.example.demo.controller;

import com.example.demo.entity.po.User;
import com.example.demo.entity.request.LoginRequest;
import com.example.demo.entity.request.UserRegisterRequest;
import com.example.demo.entity.rest.RestResult;
import com.example.demo.service.UserService;
import com.example.demo.utils.SecurityConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author wang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/sign-up")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public RestResult<String> signUp(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        userService.save(userRegisterRequest);
        return RestResult.success("注册用户成功");
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.createToken(loginRequest);
        User user = userService.find(loginRequest.getUserName());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, token);
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        userService.removeToken();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
