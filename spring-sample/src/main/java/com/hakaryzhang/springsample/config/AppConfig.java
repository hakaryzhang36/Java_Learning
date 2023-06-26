package com.hakaryzhang.springsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.hakaryzhang.springsample")
public class AppConfig {
//    @Bean
//    public MyPostProcessor myPostProcessor() {
//        return new MyPostProcessor();
//    }
}
