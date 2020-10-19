package com.chengf.transaction.multidb.controller;

import com.chengf.transaction.multidb.domain.Department;
import com.chengf.transaction.multidb.domain.User;
import com.chengf.transaction.multidb.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengaofeng
 * @date 2020年10月12日 上午11:54
 */
@RestController("/db")
public class DbController {

    @Autowired
    DbService dbService;


    @RequestMapping("/addOk")
    public String addOk() {

        User user = new User();

        user.setName("cc");
        user.setAge(20);

        Department department = new Department();

        department.setName("dd");

        department.setId("1");
        dbService.commit(user, department);

        return "OK";
    }

    @RequestMapping("/addNg")
    public String addNg() {

        User user = new User();

        user.setName("cc");
        user.setAge(20);

        Department department = new Department();

        department.setName("dd");

        dbService.commit(user, department);

        return "OK";
    }

}
