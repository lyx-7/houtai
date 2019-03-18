package com.jk.service;

import com.jk.bean.QueryParam;
import com.jk.bean.Role;
import com.jk.bean.RolePermission;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.ArrayList;
import java.util.List;

public interface RoleService {

    /**
     * 分页查询角色
     */
    SendPage getPageList(Role role, ReceivePage receivePage);

    /**
     * 添加角色
     */
    void add(Role role);

    /**
     * 删除
     */
    void delByIds(String[] ids);

    /**
     * 根据id查询（回显）
     */
    Role getById(Integer id);

    /**
     * 查询出数据库所有的角色
     */
    ArrayList<Role> getAllRole();

    /**
     * 查询当前用户拥有角色
     */
    List<Integer> getRoleIdByUserId(Integer userid);

    /**
     * 分配角色
     */
    void addRoleByUserId(QueryParam queryParam);

    /**
     * 移除角色
     */
    void removeRoleByUserId(QueryParam queryParam);

    /**
     * 授权
     */
    void addPermissionToRole(QueryParam queryParam);

    /**
     * 根据id查询（回显）
     */
    RolePermission getById2(Integer id);

}
