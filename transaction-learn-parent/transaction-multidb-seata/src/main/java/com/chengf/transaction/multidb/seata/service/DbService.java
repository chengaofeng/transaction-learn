package com.chengf.transaction.multidb.seata.service;


import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.chengf.transaction.multidb.seata.dao.DepartMentMapper;
import com.chengf.transaction.multidb.seata.dao.UserMapper;
import com.chengf.transaction.multidb.seata.domain.Department;
import com.chengf.transaction.multidb.seata.domain.User;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @GlobalTransactional(rollbackFor = Exception.class)
    public  void commit(User user, Department department) {

        log.info("=============tx begin=================");
        log.info("当前 XID: {}", RootContext.getXID());

        userService.addUser(user);

        departmentService.addDepartment(department);

    }

}
