package com.dfec.demo;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/13 14:26
 * @describe
 **/
@Profile("test")
@Configuration
public class ProductServiceTestConfiguration {
    @Bean
    @Primary
    public ProductService productService(){
        return Mockito.mock(ProductService.class);
    }
}
