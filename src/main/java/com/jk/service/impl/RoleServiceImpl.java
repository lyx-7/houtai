package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.QueryParam;
import com.jk.bean.Role;
import com.jk.bean.RolePermission;
import com.jk.mapper.RoleMapper;
import com.jk.service.RoleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 分页查询
     */
    @Override
    public SendPage getPageList(Role role, ReceivePage receivePage) {
        List<Role> count = roleMapper.getPageList(role); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Role> list = roleMapper.getPageList(role); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    /**
     * 添加角色
     */
    @Override
    public void add(Role role) {
        if(role.getId()==null){
            //没有ID就是新增
            roleMapper.add(role);
        }else{
            //有id 修改
            roleMapper.updateRole(role);
        }
    }

    /**
     * 删除
     */
    @Override
    public void delByIds(String[] ids) {
        roleMapper.delByIds(ids);
    }

    /**
     * 根据id查询（回显）
     */
    @Override
    public Role getById(Integer id) {
        return roleMapper.getById(id);
    }

    /**
     * 查询出数据库所有的角色
     */
    @Override
    public ArrayList<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    /**
     * 查询当前用户拥有角色
     */
    @Override
    public List<Integer> getRoleIdByUserId(Integer userid) {
        return roleMapper.getRoleIdByUserId(userid);
    }

    /**
     * 分配角色
     */
    @Override
    public void addRoleByUserId(QueryParam queryParam) {
        roleMapper.addRoleToUserId(queryParam.getUserid(),queryParam.getRoleid());
    }

    /**
     * 移除角色
     */
    @Override
    public void removeRoleByUserId(QueryParam queryParam) {
        roleMapper.removeRoleByUserId(queryParam.getUserid(),queryParam.getRoleid());
    }

    /**
     * 授权
     */
    @Override
    public void addPermissionToRole(QueryParam queryParam) {
        roleMapper.deletePermissionToRole(queryParam.getRoid());
        roleMapper.addPermissionToRole(queryParam.getRoid(),queryParam.getPermissionid());
    }

    /**
     * 根据id查询
     */
    @Override
    public RolePermission getById2(Integer id) {
        return roleMapper.getById2(id);
    }
}
