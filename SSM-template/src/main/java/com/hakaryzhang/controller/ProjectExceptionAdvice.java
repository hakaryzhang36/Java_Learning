package com.hakaryzhang.controller;

import com.hakaryzhang.exception.BussinessException;
import com.hakaryzhang.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doException(SystemException e) {
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BussinessException.class)
    public Result doException(BussinessException e) {
        return new Result(e.getCode(), null, e.getMessage());
    }

}
