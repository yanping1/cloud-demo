package com.work.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
        (
//        scanBasePackages = {"com.work.framework.dao"},
        exclude = DataSourceAutoConfiguration.class
)
public class NacosServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosServiceApplication.class, args);
    }

}
