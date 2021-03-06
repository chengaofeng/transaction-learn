package com.chengf.transaction.multidb.seata.service;

import com.chengf.transaction.multidb.seata.dao.DepartMentMapper;
import com.chengf.transaction.multidb.seata.domain.Department;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengaofeng
 * @date 2020年10月19日 下午4:34
 */
@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartMentMapper departMentMapper;


    public void addDepartment(Department department) {
        log.info("=============department tx begin=================");
        log.info("当前 XID: {}", RootContext.getXID());

        if(department.getId() == null) {
            throw new RuntimeException("department id is null");
        }

        departMentMapper.insert(department);
    }
}
