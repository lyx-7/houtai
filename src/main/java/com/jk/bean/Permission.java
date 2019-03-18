package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Permission implements Serializable {

    private Integer id;

    private String text;

    private Integer pid;

    private String icon;

    private String url;

    private Integer state;

    private List<Permission> children;

    private boolean checked;

}
