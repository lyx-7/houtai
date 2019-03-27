package com.jk.service;


import com.jk.bean.Staff;

public interface LoginService {

    Staff getLogin(String username, String password);

    /*void toRegist(Vip users);

    Vip getloginAcct(Vip users);*/
}
