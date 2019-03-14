package com.jk.controller;

import com.jk.bean.Log;
import com.jk.bean.Staff;
import com.jk.service.LoginService;
import com.jk.utils.ReceivePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("login")
public class LoginController {
  @Resource
  private LoginService loginService;
  @Autowired
  private MongoTemplate mongoTemplate;

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

  @RequestMapping("getMongo")
  @ResponseBody
  public List<Log> getMongo(ReceivePage rp) {

    List<Log> logs = mongoTemplate.find(null,Log.class);
    return logs;
  }

}
