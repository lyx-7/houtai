package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class QueryParam {

    private Integer userid;

    private Integer roid;

    private List<Integer> roleid;// 接收角色id

    private List<Integer> permissionid;// 接收权限id

}
