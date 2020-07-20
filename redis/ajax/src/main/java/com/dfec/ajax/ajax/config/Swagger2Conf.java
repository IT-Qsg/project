package com.dfec.ajax.ajax.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Swagger2Conf
 * @Date 2020/7/20 8:48
 * @Copyright DFEC
 **/
@Configuration
@EnableSwagger2
public class Swagger2Conf {

    public Docket createResigApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(//创建API的基本信息
                        new ApiInfoBuilder()
                        .title("Spring Boot中使用Swagger2构建RESTful APIs")
                        .description("更多请关注http://www.baidu.com")
                        .termsOfServiceUrl("http://www.baidu.com")
                        .contact("sunf")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfec.ajax.ajax.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
