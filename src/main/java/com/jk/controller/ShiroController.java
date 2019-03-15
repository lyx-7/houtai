package com.jk.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ShiroController {

    @RequestMapping("query")
    public String query(){
        return "query";
    }

    @RequestMapping("login")
    public String login(){

        return "login";
    }

    @RequestMapping("reject")
    public String reject(){
        return "reject";
    }

    @RequestMapping("toLogin")
    public String toLogin(String username, String password, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        try {
            subject.login(usernamePasswordToken);
        }  catch(UnknownAccountException e){
            System.out.println("用户名不存在");
            session.setAttribute("msg","用户名不存在");
            return "login";
        } catch(IncorrectCredentialsException e){
            System.out.println("密码或和用户名一致");
            session.setAttribute("msg","密码或和用户名不一致");
            return "login";

        }catch (AuthenticationException e) {
            e.printStackTrace();
            session.setAttribute("msg","未知的错误");
            return "login";
        }

        return "index";
    }

}
