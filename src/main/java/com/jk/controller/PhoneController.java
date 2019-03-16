package com.jk.controller;


import com.jk.bean.Constant;
import com.jk.bean.QueryParam;
import com.jk.bean.Staff;
import com.jk.service.LoginClientService;
import com.jk.service.PhoneService;
import com.jk.utils.HttpClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("phone")
public class PhoneController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private PhoneService phoneService;


    //手机发送验证码
    @ResponseBody
    @RequestMapping(value = "sendCode", produces = "application/json; charset=utf-8")
    public QueryParam sendCode(QueryParam queryParam,HttpSession session) {
        QueryParam qp = new QueryParam();
        boolean code = redisTemplate.hasKey(Constant.phone_code+queryParam.getPhone_no());
        boolean multiple= redisTemplate.hasKey(Constant.multiple_code+queryParam.getPhone_no());
        if(code) {
            //如果为true说明状态码已存在,不让发送
            qp.setCode(2);

        }else {
            qp.setCode(1);
            Map<String, Object> params = new HashMap<>();

            // 产生一个4位验证码
            int r = (int) (Math.random() * 8999) + 1000;

            redisTemplate.opsForValue().set(Constant.phone_code+queryParam.getPhone_no(),r+"",1, TimeUnit.MINUTES);
            if (multiple) {

                int s = Integer.parseInt(redisTemplate.opsForValue().get(Constant.multiple_code + queryParam.getPhone_no()));
                if (s==3) {
                    //三次了,加入到黑名单
                    qp.setCode(4);
                    return qp;
                }else{
                    //登录次数+1
                    s=s+1;
                    redisTemplate.opsForValue().set(Constant.multiple_code+queryParam.getPhone_no(),s+"");//一天登录的次数
                }
            }else{
                //redisTemplate.opsForValue().increment(Constant.multiple_code+queryParam.getPhone_no(),1);//一天登录的次数
                redisTemplate.opsForValue().set(Constant.multiple_code+queryParam.getPhone_no(),1+"",1440,TimeUnit.MINUTES);
            }

            params.put("mobile", queryParam.getPhone_no());// 手机号 前台传过来的
            params.put("tpl_id", "124321");// 模板id
            params.put("tpl_value", "%23code%23%3d" + r);// 随机验证码
            params.put("key","99f52898ecf0854b4f9423446967770a");

            String result = HttpClient.sendGet("http://v.juhe.cn/sms/send",params);//返回的验证码
            session.setAttribute("yzm",r);
        }

        return qp;
    }


    @Resource
    private LoginClientService loginClientService;

    //@ResponseBody
    @RequestMapping("login")
    public String logins(QueryParam queryParam,HttpSession session){
        if(StringUtils.isEmpty(queryParam.getVerify_code())||StringUtils.isEmpty(queryParam.getAccount())){
            session.setAttribute("msg","请输入用户名和手机号");
            return "phone";
        }
        String s = redisTemplate.opsForValue().get(Constant.phone_code + queryParam.getPhone_no());
        if(!queryParam.getVerify_code().equals(s)){
            session.setAttribute("msg","验证码不正确");
            return "phone";
        }
        Staff usersDb = phoneService.getloginAcct(queryParam.getAccount());
        if (usersDb == null) {
            session.setAttribute("msg","用户名不存在");
            return "phone";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(usersDb.getUsername(),usersDb.getPassword());
        try {
            subject.login(usernamePasswordToken);
        }  catch(UnknownAccountException e){
            System.out.println("用户名不存在");
            session.setAttribute("msg","用户名不存在");
            return "phone";
        } catch(IncorrectCredentialsException e){
            System.out.println("密码或和用户名一致");
            session.setAttribute("msg","密码或和用户名不一致");
            return "phone";
        }catch (AuthenticationException e) {
            e.printStackTrace();
            session.setAttribute("msg","未知的错误");
            return "phone";
        }
        return "index";
    }







}
