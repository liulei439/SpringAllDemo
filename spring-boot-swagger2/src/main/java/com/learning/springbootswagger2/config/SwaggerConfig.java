package com.learning.springbootswagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * swagger docket实例
     * @return
     */
    @Bean
    public Docket docket(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)              //是否激活swagger,如果是正式环境下，请把他设置为false
                .groupName("LittleFox")          //分组，可以设置多个docket
                .select()
                .paths(PathSelectors.any())
                .build();
    }


    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("LittleFox")
                .description("丝袜哥swagger")
                .version("1.0")
                .termsOfServiceUrl("termsOfServiceUrl")
                .contact(new Contact("name","url","email"))
                .build();
    }
//    下面的是默认配置 apiInfo.default
//    static {
//        DEFAULT = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
//    }
}
