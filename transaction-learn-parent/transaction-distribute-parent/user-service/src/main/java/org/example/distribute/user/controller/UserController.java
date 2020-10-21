package org.example.distribute.user.controller;

import org.example.common.domain.User;
import org.example.distribute.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengaofeng
 * @date 2020年10月21日 4:14 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        userService.addUser(user);
    }
}
