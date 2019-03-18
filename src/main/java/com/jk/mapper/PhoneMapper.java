package com.jk.mapper;

import com.jk.bean.Staff;
import org.apache.ibatis.annotations.Select;

public interface PhoneMapper {


    @Select("select * from t_staff where account=#{loginAcct}")
    Staff getloginAcct(String loginAcct);

}
