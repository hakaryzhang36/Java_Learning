package com.hakaryzhang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration                                      // 将类指定为 Spring 的配置类
@ComponentScan({"com.hakaryzhang.service"})         // bean 配置的扫描范围
@PropertySource("classpath:jdbc.properties")        // 指定项目配置文件
@Import({JdbcConfig.class, MybatisConfig.class})    // 导入配置类
public class SpringConfig {
}
