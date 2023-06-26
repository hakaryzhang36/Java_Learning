package com.hakaryzhang.springsample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class TurtleLog {
    @Pointcut("execution(* com.hakaryzhang.springsample.turtle.Turtle.*(..))")
    void pointcutMethod(){}

    @Before("pointcutMethod()")
    public void before() {
        System.out.println("Before Advice");
    }
}
