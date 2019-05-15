package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.jk.dao")
@EnableTransactionManagement  //开启事物的注解
public class YxsSpringProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(YxsSpringProviderApplication.class, args);
    }

}
