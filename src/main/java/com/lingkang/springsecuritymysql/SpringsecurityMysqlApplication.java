package com.lingkang.springsecuritymysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lingkang.springsecuritymysql.mapper"})
public class SpringsecurityMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityMysqlApplication.class, args);
    }

}
