package com.hakaryzhang.springsample.vo;

public class TurtleVo {
    Integer turtleId = null;
    String name = null;
    String sex = null;

    public TurtleVo() {

    }

    public TurtleVo(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public TurtleVo(Integer turtleId, String name, String sex) {
        this.turtleId = turtleId;
        this.name = name;
        this.sex = sex;
    }

    public Integer getTurtleId() {
        return turtleId;
    }

    public void setTurtleId(Integer turtleId) {
        this.turtleId = turtleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TurtleVo{" +
                "turtleId=" + turtleId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
