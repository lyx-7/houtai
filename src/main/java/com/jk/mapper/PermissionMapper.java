package com.jk.mapper;

import com.jk.bean.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    /**
     * 递归树（同步树）
     */
    List<Permission> queryPermission(Integer id);

    @Select("select id from t_permission where pid = #{id}")
    List<Permission> queryTreeByRoleid(Integer id);

    @Select("select permissionid from t_role_permission where roleid = #{roid}")
    List<Integer> getPermissionIdByRoleId(Integer roid);
}
