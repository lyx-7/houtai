package com.jk.bean;

import lombok.Data;

@Data
public class Advert {

    private Integer id;
    private String adtitle;//广告标题
    private String adimg;//图片
    private String adlink;//链接
    private Integer adlocation;//位置
    private Integer adstate=0;//1 显示 0 不显示

}
