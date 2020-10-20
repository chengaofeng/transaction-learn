drop table IF EXISTS chengf.t_user ;
create table chengf.t_user (
id varchar(32) not null,
name varchar(32),
age varchar(3),
primary key (id)
)


------

create  table  chengf.t_department (
id varchar(32) not null,
name varchar(32),
primary key (id)
)


CREATE TABLE chengf.undo_log
(
    id            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    branch_id     BIGINT(20)   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info LONGBLOB     NOT NULL,
    log_status    INT(11)      NOT NULL,
    log_created   DATETIME     NOT NULL,
    log_modified  DATETIME     NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY ux_undo_log (xid, branch_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;