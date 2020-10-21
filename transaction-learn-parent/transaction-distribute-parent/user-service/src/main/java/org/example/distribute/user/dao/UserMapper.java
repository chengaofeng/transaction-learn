package org.example.distribute.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.common.domain.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
