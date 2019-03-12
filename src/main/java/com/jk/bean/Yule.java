package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Yule {

    private Integer id;

    private String title;

    private Integer vipid;

    private Date time;

    private String imgtype;

    private Integer status;

    private Integer userid;

    private String tablename;

    private String imgurl;

    private String vipname;

    private String tlink;//文章链接
}
