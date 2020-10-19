package com.chengf.transaction.multidb.service;


import com.chengf.transaction.multidb.domain.Department;
import com.chengf.transaction.multidb.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chengaofeng
 * @date 2020年10月12日 上午11:54
 */
@Service
@Slf4j
public class DbService {


    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @Transactional(rollbackFor = Exception.class)
    public  void commit(User user, Department department) {

        log.info("=============tx begin=================");


        userService.addUser(user);

        departmentService.addDepartment(department);

    }

}
