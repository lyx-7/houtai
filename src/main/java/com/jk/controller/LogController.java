package com.jk.controller;

import com.jk.bean.Log;
import com.jk.bean.Staff;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Aspect       //声名切面类
@Component   //交给spring来管理
public class LogController<aspectj> {

    //日志业务
    @Autowired
    private MongoTemplate mongoTemplate;

    // 切面=切入点+通知
    // 要拦截指定的方法 给方法增加一些功能 通过切入点找到指定方法
    //1.定义一个切入点
    @Pointcut("execution( * com.jk.controller.*.*(..))")
    public void pointCut(){

    }


    //返回后通知
    @AfterReturning(value="pointCut()",returning="rtv")
    public void afterReturningDemo(JoinPoint joinPoint, Object rtv){

        String method = joinPoint.getSignature().getName();//执行方法的名字

        String className = joinPoint.getTarget().getClass().getSimpleName();//访问的类
        Object[] args = joinPoint.getArgs();//请求的参数
        String str ="{";//拼接请求的参数
        for (Object object : args) {
            str += object+",";
        }
       str +="}";

       Staff user = null;
        String url ="url未定义";
        String ip = "ip未定义";
        //这个方法是能取到request,在在里面取出session,session在这无法直接获取
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes==null) {

            System.out.println("session为空------");
        }else {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            HttpSession session = request.getSession();
            user = (Staff) session.getAttribute("user");
            url = request.getRequestURI().toString();//从request取出url,request里有很多数据

        }

        if(user==null) {
            user= new Staff();
            user.setId(-1);
            user.setUsername("未登录");
        }


        Log log = new Log(user.getId()+"",user.getUsername(), className, method, str,"无返回值",new Date(),url);

        mongoTemplate.save(log);

        System.out.println("@AfterReturning执行了,返回后通知,执行了"+joinPoint.getSignature().getName()+"方法");



    }



    //@Around抛出异常后通知

    @AfterThrowing(value="pointCut()")
    public void afterThrowingDemo (JoinPoint joinPoint) {

        System.out.println("@Around执行了,抛出异常后通知,执行了"+joinPoint.getSignature().getName()+"方法");

    }






}
