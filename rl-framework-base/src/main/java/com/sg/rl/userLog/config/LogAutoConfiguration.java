package com.sg.rl.userLog.config;


import com.sg.rl.userLog.aspect.SysLogAspect;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
