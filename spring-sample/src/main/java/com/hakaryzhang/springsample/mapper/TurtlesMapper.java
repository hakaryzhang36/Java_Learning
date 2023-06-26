package com.hakaryzhang.springsample.mapper;

import com.hakaryzhang.springsample.vo.TurtleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TurtlesMapper {
    List<TurtleVo> getAllTurtles();

    @Select("select * from turtles where turtle_id = #{turtleId}")
    TurtleVo getTurtleById(Integer turtleId);

    void addTurtle(TurtleVo turtleVo);
}
