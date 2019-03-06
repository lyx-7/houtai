package com.jk.controller;

import com.jk.bean.Staff;
import com.jk.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("login")
public class LoginController {
  @Resource
  private LoginService loginService;

  @ResponseBody
  @RequestMapping("login")
  public String getLogin(Staff users, HttpSession session){
    Staff usersFromdb = loginService.getLogin(users);
    if(usersFromdb==null){
      return "2";
    }
    session.setAttribute("user",usersFromdb);
    return "1";
  }


}
