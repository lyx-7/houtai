package com.jk.mapper;


import com.jk.bean.Staff;
import org.apache.ibatis.annotations.Param;

public interface LoginsMapper {

    Staff getLogin(@Param("username") String username,@Param("password") String password);


   /* void toRegist(Vip users);

    Vip getloginAcct(Vip users);*/
}
