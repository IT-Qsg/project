package com.dfec.springbootmybatis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/10 8:51
 * @describe 配置多个数据源
 **/
@Configuration
public class ConnDataSource {
    @Bean(name = "dbProductService")
    @ConfigurationProperties(prefix = "spring.datasource.dbproductservice")
    @Primary
    public DataSource createProductServiceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dbUserService")
    @ConfigurationProperties(prefix = "spring.datasource.dbuserservice")
    public DataSource createUserServiceDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcProductService")
    @Autowired
    public JdbcTemplate createJdbcTemplate_ProductService(@Qualifier("dbProductService") DataSource productServiceDS) {
        return new JdbcTemplate(productServiceDS);
    }
    @Bean(name = "jdbcUserService")
    @Autowired
    public JdbcTemplate createJdbcTemplate_UserService(@Qualifier("dbUserService") DataSource userServiceDS) {
        return new JdbcTemplate(userServiceDS);
    }
}
