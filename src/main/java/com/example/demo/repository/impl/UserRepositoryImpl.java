package com.example.demo.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.po.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jielum
 */
@Repository
public class UserRepositoryImpl
        extends ServiceImpl<UserMapper, User>
        implements UserRepository {
}
