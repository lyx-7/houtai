package com.jk.bean;

import lombok.Data;

@Data
public class Vip {
  Integer id;
  String vipname;
  String vipaccount;
  String vippassword;
  String vipheadimg;
  Integer role;
  Integer status;
  Integer vipState;
}