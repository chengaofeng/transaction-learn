package com.chengf.transaction.multidb.seata.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chengf.transaction.multidb.seata.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("mysql_chengf3307")
public interface UserMapper extends BaseMapper<User> {
}
