package com.sg.rl;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class,
        DataSourceAutoConfiguration.class/*, RedisAutoConfiguration.class*/})
public class DbConfig {
}
