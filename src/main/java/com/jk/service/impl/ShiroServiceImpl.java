package com.jk.service.impl;

import com.jk.bean.Staff;
import com.jk.mapper.ShiroMapper;
import com.jk.service.ShiroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private ShiroMapper shiroMapper;

    @Override
    public String queryUser(String username) {

        return shiroMapper.queryUser(username);
    }

    @Override
    public Staff getUser(String username) {
        return shiroMapper.getUser(username);
    }

    @Override
    public List<String> getRole(Staff staff) {

        return shiroMapper.getRole(staff.getUsername());
    }

    @Override
    public List<String> getPermission(String username) {
        return shiroMapper.getPermission(username);
    }
}
