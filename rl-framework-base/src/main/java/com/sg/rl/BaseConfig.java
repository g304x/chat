package com.sg.rl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan(basePackages = {"com.sg.rl"})
@EnableAsync
public class BaseConfig {
}
