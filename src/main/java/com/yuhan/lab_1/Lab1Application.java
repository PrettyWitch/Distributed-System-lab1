package com.yuhan.lab_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = "com.yuhan.lab_1")
//@MapperScan( basePackages = "com.yuhan.lab_1")
//@ComponentScan(basePackages = "com.yuhan.lab_1")
//@EnableJpaRepositories(basePackages = {"com.yuhan.lab_1.dao"})
//@EntityScan(basePackages = "com.yuhan.lab_1.domain")
@SpringBootApplication
public class Lab1Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Lab1Application.class, args);
    }

}
