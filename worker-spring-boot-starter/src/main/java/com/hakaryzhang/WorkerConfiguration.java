package com.hakaryzhang;

import com.hakaryzhang.exported.Worker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfiguration {

    @Bean
    @ConditionalOnClass(Worker.class)   // 当 Worker 被依赖时才将实例注入 IOC 容器
    public Worker worker() {
        return new Worker();
    }
}
