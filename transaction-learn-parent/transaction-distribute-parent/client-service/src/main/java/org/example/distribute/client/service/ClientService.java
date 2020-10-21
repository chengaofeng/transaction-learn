package org.example.distribute.client.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.example.common.domain.Department;
import org.example.common.domain.User;
import org.example.distribute.client.department.DepartmentClient;
import org.example.distribute.client.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengaofeng
 * @date 2020年10月21日 4:29 下午
 */
@Service
public class ClientService {
    @Autowired
    UserClient userClient;

    @Autowired
    DepartmentClient departmentClient;

    @GlobalTransactional(rollbackFor = Exception.class)
    public  void commit(User user, Department department) {
        userClient.insert(user);

        departmentClient.insert(department);

    }
}
