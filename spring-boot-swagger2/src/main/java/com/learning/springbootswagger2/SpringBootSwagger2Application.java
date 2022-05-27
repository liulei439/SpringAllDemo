package com.learning.springbootswagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


/**
 * http://localhost:8080/web/swagger-ui/   swagger访问路径
 */
@SpringBootApplication
@EnableOpenApi
public class SpringBootSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwagger2Application.class, args);
    }

}
