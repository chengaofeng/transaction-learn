package org.example.distribute.client.user;

import org.example.common.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chengaofeng
 * @date 2020年10月21日 4:20 下午
 */
@FeignClient(name="userClient", url="http://localhost:8081")
@RequestMapping("/user")
public interface UserClient {
    @PostMapping("/insert")
    void insert(@RequestBody User user);
}
