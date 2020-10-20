package com.chengf.transaction.multidb.seata.controller;


import com.chengf.transaction.multidb.seata.domain.Department;
import com.chengf.transaction.multidb.seata.domain.User;
import com.chengf.transaction.multidb.seata.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengaofeng
 * @date 2020年10月12日 上午11:54
 */
@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    DbService dbService;


    @GetMapping("/addOk/{id}")
    public String addOk(@PathVariable String id) {

        User user = new User();
        user.setId(id);
        user.setName("cc");
        user.setAge(20);

        Department department = new Department();

        department.setName("dd");

        department.setId(id);
        dbService.commit(user, department);

        return "OK";
    }

    @GetMapping("/addNg/{id}")
    public String addNg(@PathVariable String id) {

        User user = new User();
        user.setId(id);
        user.setName("cc");
        user.setAge(20);

        Department department = new Department();

        department.setName("dd");

        dbService.commit(user, department);

        return "NG";
    }

}
