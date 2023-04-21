create table product
(
    pid         integer not null auto_increment,
    pro_name    VARCHAR2(64),
    create_time timestamp default CURRENT_TIME(),
    constraint product_pk_id
        primary key (pid)
);

comment on table product is '产品表';

comment on column product.pid is '主键';

comment on column product.pro_name is '产品名称';

comment on column product.create_time is '创建时间';

create table sys_log
(
    log_id      integer not null auto_increment,
    remark      VARCHAR2(256),
    create_time timestamp default CURRENT_TIME(),
    constraint sys_log_pk_id
        primary key (log_id)
);
comment on table sys_log is '系统日志表';

comment on column sys_log.log_id is '主键';

comment on column sys_log.remark is '日志信息';

comment on column sys_log.create_time is '创建时间';