package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jielum
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
