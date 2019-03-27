package com.jk.controller;

import com.jk.bean.Log;
import com.jk.bean.Staff;
import com.jk.service.LoginService;
import com.jk.utils.ExportExcel;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("login")
public class LoginController {
  @Resource
  private LoginService loginService;
  @Autowired
  private MongoTemplate mongoTemplate;

  //分页查询日志
  @RequestMapping("getMongo")
  @ResponseBody
  public SendPage getMongo(ReceivePage rp){
    Query query = new Query();
    int count = (int) mongoTemplate.count(query, Log.class);
    query.skip((rp.getPage() - 1) * rp.getRows());//
    query.limit(rp.getRows());// 每页展示的条数
    List<Log> logs = mongoTemplate.find(query, Log.class);
    SendPage sendPage = new SendPage(count, logs);// java 的装箱和拆箱
    return sendPage;
  }

  //删除日志
  @RequestMapping("deleteLogs")
  @ResponseBody
  public String deleteLogs(String ids) {

    Query query = new Query();
    String[] idsArr = ids.split(",");

    mongoTemplate.remove(query.addCriteria(Criteria.where("id").in(idsArr)), Log.class);
    return "1";

  }



  //poi导出
  @RequiresPermissions("del")
  @RequestMapping("exportExcel")
  public void exportExcel(HttpServletResponse response, String ids) {

    Query query = new Query();
    String[] idsArr = ids.split(",");
    List<Log> list = mongoTemplate.find(query.addCriteria(Criteria.where("id").in(idsArr)), Log.class);

    //使用poi将导出
    String title = "日志列表";
    String[] rowName = {"日志ID", "登录用户名", "访问类名","请求参数","请求方法名","路径"};
    List<Object[]> dataList = new ArrayList<Object[]>();
    Object[] obj = null;
    for (Log lg : list) {
      obj = new Object[rowName.length];
      obj[0] = lg.getId();
      obj[1] = lg.getUserName();
      obj[2] = lg.getClassName();
      obj[3] = lg.getReqParam();
      obj[4] =lg.getMethod();
      obj[5] =lg.getUrl();
      dataList.add(obj);
    }

    ExportExcel exportExcel = new ExportExcel(title, rowName, dataList, response);
    try {
      exportExcel.export();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
