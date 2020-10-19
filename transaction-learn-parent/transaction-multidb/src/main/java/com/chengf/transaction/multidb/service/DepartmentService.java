package com.chengf.transaction.multidb.service;

import com.chengf.transaction.multidb.dao.DepartMentMapper;
import com.chengf.transaction.multidb.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengaofeng
 * @date 2020年10月19日 下午4:34
 */
@Service
public class DepartmentService {

    @Autowired
    DepartMentMapper departMentMapper;


    public void addDepartment(Department department) {
        if(department.getId() == null) {
            throw new RuntimeException("department id is null");
        }

        departMentMapper.insert(department);
    }
}
