package com.jk.service.impl;

import com.jk.bean.Staff;
import com.jk.mapper.LoginsMapper;
import com.jk.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginsMapper loginMapper;


    @Override
    public Staff getLogin(Staff users) {

        return loginMapper.getLogin(users);
    }

   /* @Override
    public void toRegist(Vip users) {
        loginMapper.toRegist(users);
    }

    @Override
    public Vip getloginAcct(Vip users) {
        return loginMapper.getloginAcct(users);
    }*/
}
