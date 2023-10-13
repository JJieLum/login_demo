-- auto-generated definition
create table role
(
    id          int auto_increment comment '数据标识'
        primary key,
    name        varchar(50) not null comment '名字',
    description varchar(50) null comment '备注'
)
    comment '权限表' row_format = DYNAMIC;

