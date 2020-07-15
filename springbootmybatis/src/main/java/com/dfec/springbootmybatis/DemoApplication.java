package com.dfec.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan({"com.dfec.springbootmybatis.mapper","com.dfec.springbootmybatis.file"})
@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动后输出 spring boot 运行器");
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
