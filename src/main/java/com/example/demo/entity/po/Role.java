package com.example.demo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jielum
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String description;
}
