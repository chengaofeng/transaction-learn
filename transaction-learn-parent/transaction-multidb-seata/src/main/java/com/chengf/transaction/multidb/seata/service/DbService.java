package com.chengf.transaction.multidb.seata.service;


import com.chengf.transaction.multidb.seata.dao.DepartMentMapper;
import com.chengf.transaction.multidb.seata.dao.UserMapper;
import com.chengf.transaction.multidb.seata.domain.Department;
import com.chengf.transaction.multidb.seata.domain.User;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @GlobalTransactional(rollbackFor = Exception.class)
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
