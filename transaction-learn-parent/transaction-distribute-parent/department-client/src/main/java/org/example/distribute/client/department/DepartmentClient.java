package org.example.distribute.client.department;

import org.example.common.domain.Department;
import org.example.common.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chengaofeng
 * @date 2020年10月21日 4:20 下午
 */
@FeignClient(name="departmentClient", url="http://localhost:8082")
@RequestMapping("/department")
public interface DepartmentClient {
    @PostMapping("/insert")
    void insert(@RequestBody Department department);
}
