package com.example.demo.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.po.Role;

/**
 * @author jielum
 */
public interface RoleRepository extends IService<Role> {

    /**
     * 查询角色权限
     * @param userName 用户名
     * @return string
     */
    String getRole(String userName);
}
