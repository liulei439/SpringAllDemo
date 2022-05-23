package com.learning.multidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringBootMybatisMultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisMultidatasourceApplication.class, args);
    }

}
