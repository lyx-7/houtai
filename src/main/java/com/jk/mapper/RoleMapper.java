package com.jk.mapper;

import java.util.ArrayList;
import java.util.List;

import com.jk.bean.Role;
import com.jk.bean.RolePermission;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    /**
     * 分页查询角色
     */
    List<Role> getPageList(Role role);

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
     * 修改
     */
    void updateRole(Role role);

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
    void addRoleToUserId(@Param("userid") Integer userid, @Param("roleid") List<Integer> roleid);

    /**
     * 移除角色
     */
    void removeRoleByUserId(@Param("userid") Integer userid, @Param("roleid") List<Integer> roleid);

    /**
     * 授权
     */
    void addPermissionToRole(@Param("roid") Integer roid, @Param("permissionid") List<Integer> permissionid);

    /**
     * 根据id查询
     */
    RolePermission getById2(Integer id);

    void deletePermissionToRole(Integer roid);
}
