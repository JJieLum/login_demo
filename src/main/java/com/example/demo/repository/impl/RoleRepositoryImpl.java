package com.example.demo.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.po.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author jielum
 */
@Repository
public class RoleRepositoryImpl
        extends ServiceImpl<RoleMapper, Role>
        implements RoleRepository {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public String getRole(String userName) {
        return roleMapper.getRole(userName);
    }
}
