package com.neu.carpark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neu.carpark.mapper")
public class CarparkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarparkApplication.class, args);
    }

}

