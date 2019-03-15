package com.jk.service;

import com.jk.bean.Staff;

import java.util.List;

public interface ShiroService {

    String queryUser(String username);

    Staff getUser(String username);

    List<String> getRole(Staff staff);

    List<String> getPermission(String username);

}
