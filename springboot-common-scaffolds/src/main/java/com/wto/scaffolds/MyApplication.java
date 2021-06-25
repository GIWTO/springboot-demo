package com.wto.scaffolds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.TimeZone;

@EnableTransactionManagement
@MapperScan(basePackages = "com.wto.scaffolds.mapper")
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        /*项目启动时保证服务器时区为GMT+8*/
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication.run(MyApplication.class, args);
    }

}
