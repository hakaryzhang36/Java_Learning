package com.hakaryzhang.springsample;

import com.hakaryzhang.springsample.turtle.Turtle;
import com.hakaryzhang.springsample.turtle.turtleImp.GreenTurtle;
import com.hakaryzhang.springsample.turtle.turtleImp.RedTurtle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 三种依赖注入示例代码
 */
@Component
public class SeaAnimalsParty {

    @Autowired                          // 字段注入
    @Qualifier(value = "greenTurtle")   // 指定类名称
    private Turtle turtleA1;
    @Autowired
    private Turtle greenTurtle;         // 不指定类名称，Autowire 只能根据变量名匹配。不匹配会报错。

    @Resource(name = "greenTurtle")     // 字段注入
    private Turtle turtleA2;
    @Resource
    private RedTurtle turtle;           // 不指定类名称，Resource 只能根据类名匹配。不匹配会报错。


    private final Turtle turtleB;       // 构造器注入
    private Turtle turtleC = null;      // setter 方法注入

    @Autowired
    public SeaAnimalsParty(@Qualifier("greenTurtle") Turtle turtleB) {
        this.turtleB = turtleB;
    }

    @Autowired
    public void setTurtleC(@Qualifier("redTurtle") Turtle turtleC) {
        this.turtleC = turtleC;
    }

    public void startParty() {
        turtleA1.swim();
        turtleA2.swim();
        turtleB.swim();
        turtleC.swim();
    }
}
