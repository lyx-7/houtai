package com.jk.service;

import com.jk.bean.Staff;

public interface PhoneService {

    Staff getloginAcct(String loginAcct);

    Staff loginAcct(Staff staff);

    void toRegist(Staff staff);
}