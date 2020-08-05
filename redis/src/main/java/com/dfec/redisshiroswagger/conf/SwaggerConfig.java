package com.dfec.redisshiroswagger.conf;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname SwaggerConfig
 * @Date 2020/7/21 9:19
 * @Copyright DFEC
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket createResigApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(//创建API的基本信息
                        new ApiInfoBuilder()
                        .title("Spring Boot shiro中使用Swagger2构建RESTful APIs")
                        .description("更多请关注http://www.baidu.com")
                        .termsOfServiceUrl("http://www.baidu.com")
                        .contact("shiro")
                        .version("1.0 v")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfec.redisshiroswagger.Controller"))
                .paths(PathSelectors.any())
                .build();
    }
   /* //是否开启swagger，根据环境来选择
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket Lamp() {

        Parameter token = new ParameterBuilder().name("token")  //全局参数
                .description("用户登陆令牌")
                .parameterType("header")
                .modelRef(new ModelRef("String"))
                .required(true)
                .build();
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(token);
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameters)
                .apiInfo(apiInfo())
                .groupName("灯")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfec.redisshiroswagger.Controller"))
                .paths(Predicates.or(
                        PathSelectors.regex("/lamp.*"),
                        PathSelectors.regex("/lampState.*")
                ))
                .build();
    }
    @Bean
    public Docket LampState() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("获取Token")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dfec.redisshiroswagger.Controller"))
                .paths(PathSelectors.ant("/GetToken"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("shiro-redis")
                .description("api")
                // 作者信息
//                .contact(new Contact("Qsg", null, "123456789@qq.com"))
                .version("1.0.0 v")
                .build();
    }*/
}
