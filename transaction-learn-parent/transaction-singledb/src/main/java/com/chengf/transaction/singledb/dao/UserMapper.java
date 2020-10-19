package com.chengf.transaction.singledb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chengf.transaction.singledb.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
