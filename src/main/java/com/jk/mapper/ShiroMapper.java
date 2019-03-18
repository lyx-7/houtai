package com.jk.mapper;

import com.jk.bean.Staff;

import java.util.List;

public interface ShiroMapper {

    String queryUser(String username);

    Staff getUser(String username);

    List<String> getRole(String username);

    List<String> getPermission(String username);

}
