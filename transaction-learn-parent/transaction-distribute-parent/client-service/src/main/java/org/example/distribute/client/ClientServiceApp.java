package org.example.distribute.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chengaofeng
 * @date 2020年10月21日 3:54 下午
 */
@SpringBootApplication
@EnableFeignClients
public class ClientServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApp.class, args);
    }
}
