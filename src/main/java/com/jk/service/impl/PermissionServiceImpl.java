package com.jk.service.impl;

import com.jk.bean.Permission;
import com.jk.bean.QueryParam;
import com.jk.mapper.PermissionMapper;
import com.jk.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 递归树（同步树）
     */
    @Override
    public List<Permission> queryPermission() {
        Integer id = 0;
        List<Permission> permissionNode = permissionNode(id);
        return permissionNode;
    }

    private List<Permission> permissionNode(Integer id) {
        List<Permission> permissions = permissionMapper.queryPermission(id);
        for (Permission permissionBean : permissions) {
            List<Permission> permissionNode = permissionNode(permissionBean.getId());
            permissionBean.setChildren(permissionNode);
        }
        return permissions;
    }

    /**
     * 回显选中的
     */
    @Override
    public List<Permission> queryTreeByRoleid(QueryParam queryParam) {
        List<Permission> list = permissionMapper.queryPermission(0);
        // 查询需要勾选tree的id
        List<Integer> permissionIds = permissionMapper.getPermissionIdByRoleId(queryParam.getRoid());
        getTree(permissionIds, list);
        return list;
    }

    private void getTree(List<Integer> permissionIds, List<Permission> list) {
        for (Permission permission : list) {
            List<Permission> date = permissionMapper.queryPermission(permission.getId());
            getTree(permissionIds, date);
            // 如果一个节点是不勾选状态 则其祖先节点不能为勾选状态
            // if(permission.getId()==115||permission.getId()==107||permission.getId()==0)
            // permission.setChecked(false);
            permission.setChildren(date);
            // 什么该勾选
            if (permissionIds != null) {
                // exisChildren 有子节点是 true  (!exisChildren)-->没有孩子
                boolean exisChildren = permission.getChildren() != null && permission.getChildren().size() > 0;
                // 如果当前节点有子节点就不能为勾选状态 如果子节点中有未勾选的节点 父节点如果选中择所有子节点全为勾选状态
                if (permissionIds.contains(permission.getId()) && !exisChildren) {//
                    //如果当前遍历的树在 permissionIds集合中则当前树应该是勾选状态
                    //如果当前遍历的树在 permissionIds集合中 并且当前节点没有子节点
                    permission.setChecked(true); //就把其设置为勾选状态
                }
            }
        }
    }
}
