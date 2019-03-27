package com.jk.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyController {

    //@ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception ex) {
        System.out.println("查询全局异常了");
        return "reject";
    }
}
