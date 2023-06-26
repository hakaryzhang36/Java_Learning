package com.hakaryzhang.springsample;

import com.hakaryzhang.springsample.config.AppConfig;
import com.hakaryzhang.springsample.config.MyBeanNameGenerator;
import com.hakaryzhang.springsample.config.MyPostProcessor;
import com.hakaryzhang.springsample.mapper.TurtlesMapper;
import com.hakaryzhang.springsample.turtle.Turtle;
import com.hakaryzhang.springsample.turtle.turtleImp.TurtleInCycleA;
import com.hakaryzhang.springsample.turtle.turtleImp.TurtleWithInit;
import com.hakaryzhang.springsample.vo.TurtleVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.SpringVersion;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringSampleApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ac =
                new SpringApplicationBuilder(SpringSampleApplication.class)
                        .allowCircularReferences(true).run();  // 新建容器，允许循环依赖


        // test
        Turtle turtle = ac.getBean(TurtleInCycleA.class);


    }

}
