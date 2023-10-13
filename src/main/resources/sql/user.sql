-- auto-generated definition
create table user
(
    id        int auto_increment comment '数据标识'
        primary key,
    user_name varchar(50)  not null comment '用户名',
    password  varchar(255) not null comment '密码'
)
    comment '用户表' row_format = DYNAMIC;

