package com.hakaryzhang.springsample.config;

import com.hakaryzhang.springsample.turtle.turtleImp.TurtleWithInit;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * Springboot 中配置一个 Bean初始化前置、后置处理器 的示例
 */
public class MyPostProcessor implements BeanPostProcessor {     // 继承 BeanPostProcessor
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 只对 TurtleWithInit 生效
        if (bean instanceof TurtleWithInit) {
            System.out.println("4 - Post processor BEFORE initialize bean...");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 只对 TurtleWithInit 生效
        if (bean instanceof TurtleWithInit) {
            System.out.println("6 - Post processor AFTER initialize bean...");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
