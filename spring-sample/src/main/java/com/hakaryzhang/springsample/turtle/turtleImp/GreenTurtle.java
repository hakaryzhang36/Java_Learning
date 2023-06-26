package com.hakaryzhang.springsample.turtle.turtleImp;

import com.hakaryzhang.springsample.turtle.Turtle;
import org.springframework.stereotype.Component;

@Component("greenTurtle")
public class GreenTurtle implements Turtle {
    @Override
    public void swim() {
    }

    public GreenTurtle() {
    }
}
