package com.chengf.transaction.singledb.test;


import com.chengf.transaction.singledb.TransactionSingleDbApp;
import com.chengf.transaction.singledb.domain.Department;
import com.chengf.transaction.singledb.domain.User;
import com.chengf.transaction.singledb.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengaofeng
 * @date 2020年10月13日 下午12:01
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionSingleDbApp.class)
public class TransactionTest {

    @Autowired
    DbService dbService;

    @Test
    public void test() {

        User user = new User();

        user.setName("cc6");
        user.setAge(20);

        Department department = new Department();

        department.setName("dd");

//        department.setId("6");
        dbService.commit(user,department);

        System.out.println("OK");


    }

}
