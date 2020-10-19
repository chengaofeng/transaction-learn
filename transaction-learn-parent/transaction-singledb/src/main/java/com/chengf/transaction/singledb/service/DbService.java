package com.chengf.transaction.singledb.service;

import com.chengf.transaction.singledb.dao.DepartMentMapper;
import com.chengf.transaction.singledb.domain.Department;
import com.chengf.transaction.singledb.domain.User;
import com.chengf.transaction.singledb.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chengaofeng
 * @date 2020年10月12日 上午11:54
 */
@Service
public class DbService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    DepartMentMapper departMentMapper;


    @Transactional(rollbackFor = Exception.class)
    public  void commit(User user, Department department) {

        if (user.getAge() < 10) {
            throw new RuntimeException("age less than 10");
        }

        userMapper.insert(user);

        if(department.getId() == null) {
            throw new RuntimeException("department id is null");
        }

        departMentMapper.insert(department);

    }

}
