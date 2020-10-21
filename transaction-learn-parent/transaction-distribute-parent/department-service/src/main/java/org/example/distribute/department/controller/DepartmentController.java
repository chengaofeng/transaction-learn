package org.example.distribute.department.controller;

import org.example.common.domain.Department;
import org.example.distribute.department.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/insert")
    public void insert(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }
}
