package com.jk.bean;

import lombok.Data;

@Data
public class Result {

    //返回给前台的状态码
    private Integer code;

    private String msg;

    private Object data;

    private boolean state = true;

}
