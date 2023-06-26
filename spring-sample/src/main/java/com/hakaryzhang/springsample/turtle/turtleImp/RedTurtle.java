package com.hakaryzhang.springsample.turtle.turtleImp;

import com.hakaryzhang.springsample.turtle.Turtle;
import org.springframework.stereotype.Component;

@Component("redTurtle")
public class RedTurtle implements Turtle {
    @Override
    public void swim() {
        System.out.println("Red turtle swimming~~");
    }

    public RedTurtle() {
    }
}
