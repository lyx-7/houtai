package com.jk.service;

import com.jk.bean.Permission;
import com.jk.bean.QueryParam;

import java.util.List;

public interface PermissionService {

    /**
     * 递归树（同步树）
     */
    List<Permission> queryPermission();


    List<Permission> queryTreeByRoleid(QueryParam queryParam);
}
