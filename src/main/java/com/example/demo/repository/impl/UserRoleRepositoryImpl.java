package com.example.demo.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.po.UserRole;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jielum
 */
@Repository
public class UserRoleRepositoryImpl
        extends ServiceImpl<UserRoleMapper, UserRole>
        implements UserRoleRepository {
}
