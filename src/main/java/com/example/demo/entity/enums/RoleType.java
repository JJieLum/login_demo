package com.example.demo.entity.enums;

import lombok.Getter;

/**
 * @author jielum
 */
@Getter
public enum RoleType {
    /**
     * 用户角色
     */
    USER("USER", "2"),
    /**
     * 管理员角色
     */
    ADMIN("ADMIN", "1");
    private final String name;
    private final String description;

    RoleType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
