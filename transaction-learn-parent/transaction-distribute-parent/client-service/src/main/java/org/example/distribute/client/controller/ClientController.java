package org.example.distribute.client.controller;

import org.example.common.domain.Department;
import org.example.common.domain.User;
import org.example.distribute.client.service.ClientService;
import org.example.distribute.client.user.UserClient;
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
public class ClientController {


    @Autowired
    ClientService clientService;


    @GetMapping("/addOk/{id}")
    public String addOk(@PathVariable String id) {

        User user = new User();
        user.setId(id);
        user.setName("cc");
        user.setAge(20);



        Department department = new Department();

        department.setName("dd");

        department.setId(id);


        clientService.commit(user, department);
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

        clientService.commit(user, department);

        return "NG";
    }

}
