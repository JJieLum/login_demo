package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author jielum
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户名获取角色
     * @param userName 用户名
     * @return role
     */
    @Select("SELECT name FROM role r JOIN user_role ur on r.id = ur.role_id WHERE ur.user_id = (SELECT id FROM user WHERE user_name = #{userName})")
    String getRole(String userName);
}
