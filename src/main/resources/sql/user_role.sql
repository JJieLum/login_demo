-- auto-generated definition
create table user_role
(
    id      int auto_increment comment '数据标识'
        primary key,
    user_id int not null comment '用户id',
    role_id int not null comment '角色id',
    constraint user_role_user_id_uindex
        unique (user_id)
)
    comment '用户权限关联表' row_format = DYNAMIC;

