package com.hakaryzhang.springsample.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;

public class MyBeanNameGenerator implements BeanNameGenerator {
    int i = 0;
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 默认生成 BeanName 策略
        String beanClassName = beanDefinition.getBeanClassName();
        System.out.println(beanClassName);
        assert beanClassName != null;
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
}
