package com.example.demo.service;

import com.example.demo.entity.po.User;
import com.example.demo.entity.request.LoginRequest;
import com.example.demo.entity.request.UserRegisterRequest;

/**
 * @author wang
 */
public interface UserService {

    /**
     * 用户注册
     * @param userRegisterRequest 请求体
     */
    void save(UserRegisterRequest userRegisterRequest);

    /**
     * 创建token
     * @param loginRequest 注册请求体
     * @return token
     */
    String createToken(LoginRequest loginRequest);

    /**
     * 查找用户
     * @param userName 用户名
     * @return user
     */
    User find(String userName);

    /**
     * 移除token
     */
    void removeToken();
}
