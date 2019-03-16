package com.jk.service.impl;

import com.jk.bean.Staff;
import com.jk.mapper.PhoneMapper;
import com.jk.service.PhoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Resource
    private PhoneMapper phoneMapper;



    @Override
    public Staff getloginAcct(String loginAcct) {
        return phoneMapper.getloginAcct(loginAcct);
    }
}
