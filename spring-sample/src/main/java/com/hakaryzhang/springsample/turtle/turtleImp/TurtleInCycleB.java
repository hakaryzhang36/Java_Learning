package com.hakaryzhang.springsample.turtle.turtleImp;

import com.hakaryzhang.springsample.turtle.Turtle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class TurtleInCycleB implements Turtle {

    private TurtleInCycleA player;

    @Autowired
    public void setPlayer(TurtleInCycleA player) {
        this.player = player;
    }

    @Override
    public void swim() {
        System.out.println("Poor turtle only swim in circle...");
    }
}
