package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.bo.JwtUser;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.entity.po.User;
import com.example.demo.entity.po.UserRole;
import com.example.demo.entity.request.LoginRequest;
import com.example.demo.entity.request.UserRegisterRequest;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtTokenUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author jielum
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void save(UserRegisterRequest userRegisterRequest) {
        // 判断用户名是否存在
        Optional.ofNullable(userRepository.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, userRegisterRequest.getUserName()))).ifPresent(task -> {
            throw new AlreadyExistException(String.format("【%s】用户名已经存在，请重新设置", userRegisterRequest.getUserName()));
        });
        // 构建User
        User user = User.builder()
                .userName(userRegisterRequest.getUserName())
                .password(userRegisterRequest.getPassword())
                .build();
        user.setPassword(bCryptPasswordEncoder.encode(userRegisterRequest.getPassword()));
        userRepository.save(user);
        // 构建用户权限
        UserRole userRole = UserRole.builder().userId(user.getId()).roleId(Integer.valueOf(RoleType.USER.getDescription())).build();
        // 保存用户权限
        userRoleRepository.save(userRole);
    }

    @Override
    public String createToken(LoginRequest loginRequest) {
        User user = find(loginRequest.getUserName());
        if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("密码错误，请重试");
        }

        String roleName = roleRepository.getRole(loginRequest.getUserName());
        List<SimpleGrantedAuthority> authoritieList = new ArrayList<>();
        authoritieList.add(new SimpleGrantedAuthority("ROLE_" + roleName));

        JwtUser jwtUser = new JwtUser(user, authoritieList);
        List<String> authorities = jwtUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = JwtTokenUtils.createToken(user.getUserName(), user.getId().toString(), authorities);
        stringRedisTemplate.opsForValue().set(user.getId().toString(), token, 15, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public User find(String userName) {
        return userRepository.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, userName));
    }

    @Override
    public void removeToken() {

    }

}