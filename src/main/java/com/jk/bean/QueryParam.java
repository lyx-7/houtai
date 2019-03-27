package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryParam implements Serializable {

    private Integer userid;

    private Integer roid;

    private List<Integer> roleid;// 接收角色id

    private List<Integer> permissionid;// 接收权限id

    //返回给前台的状态码
    private Integer code;

    private String account;//用户输入的账号
    private String phone;//发送验证码的手机号
    private String verify_code;//用户输入的验证码




}