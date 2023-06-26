package com.hakaryzhang.springsample.turtle.turtleImp;

import com.hakaryzhang.springsample.turtle.Turtle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 描述：SpringBoot 中为一个 Bean 配置初始化方法的示例
 * 实现 InitializingBean 接口
 */
@Component
public class TurtleWithInit implements Turtle, InitializingBean, BeanNameAware {
    private String type;
    private String beanId;

    public TurtleWithInit() {
        System.out.println("1 - Get a instance of TurtleWithInit!");
    }

    /**
     * setter 依赖注入
     */
    @Autowired
    public void setType(@Value("Turtle") String type) {
        this.type = type;
        System.out.println("2 - Properties set (DI)");
    }

    /**
     * 实现 BeanNameAware 接口
     */
    @Override
    public void setBeanName(String s) {
        this.beanId = s;
        System.out.println("3 - Aware method, get bean id: " + beanId);
    }

    /**
     * 初始化方法 afterPropertiesSet
     * 从名字上都可以看出这是完成依赖注入执行的方法。
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5 - Init Turtle-Bean!");
    }


    @Override
    public void swim() {
        System.out.println("Turtle is swimming");
    }
}
