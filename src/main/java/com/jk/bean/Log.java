package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "log")
public class Log {

    private String id;

    private String userId;//登录用户的id

    private String userName;//登录用户的名字

    private String className;//访问方法类名称

    private String method;    //访问的方法名

    private String reqParam;  //请求的参数

    private String respParam; //返回的参数

    private Date createTime;//创建时间

    private String url;   //用户访问的url

    public Log(String userId, String userName, String className, String method, String reqParam, String respParam, Date createTime, String url) {
        this.userId = userId;
        this.userName = userName;
        this.className = className;
        this.method = method;
        this.reqParam = reqParam;
        this.respParam = respParam;
        this.createTime = createTime;
        this.url = url;
    }
}
