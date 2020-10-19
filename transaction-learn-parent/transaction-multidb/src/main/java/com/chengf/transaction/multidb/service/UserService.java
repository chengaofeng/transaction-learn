package com.chengf.transaction.multidb.service;

import com.chengf.transaction.multidb.dao.UserMapper;
import com.chengf.transaction.multidb.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengaofeng
 * @date 2020年10月19日 下午4:32
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void addUser(User user) {
        log.info("=============user=================");

        if (user.getAge() < 10) {
            throw new RuntimeException("age less than 10");
        }

        userMapper.insert(user);
    }
}
