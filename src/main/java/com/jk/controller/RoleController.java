package com.jk.controller;

import com.jk.bean.QueryParam;
import com.jk.bean.Result;
import com.jk.bean.Role;
import com.jk.bean.RolePermission;
import com.jk.service.RoleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询
     */
    @RequiresPermissions(value = "query")
    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(Role role, ReceivePage receivePage) {
        SendPage  sp = roleService.getPageList(role, receivePage);
        return sp;
    }

    /**
     * 添加
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(Role role) {
        roleService.add(role);
        return "1";
    }

    /**
     * 物理删除
     */
    @RequiresPermissions(value = "del")
    @RequestMapping("delByIds")
    @ResponseBody
    public String delByIds(String[] ids) {
        roleService.delByIds(ids);
        return "1";
    }

    /**
     * 根据id查询（回显）update
     */
    @RequiresPermissions(value = "update")
    @RequestMapping("getById")
    @ResponseBody
    public Role getById(Integer id){
        return roleService.getById(id);
    }


    /**
     * 查询用户拥有的id和数据库的角色
     */
    @RequiresPermissions(value = "add")
    @RequestMapping("assignRole")
    public String assignRole(Integer userid,Model model) {//,HttpSession session
        ArrayList<Role> assignRole = new ArrayList<>();//定义已分配的角色
        ArrayList<Role> unassignRole = new ArrayList<>();//定义未分配的角色
        // 先查询出数据库所有的角色
        // {id:1,name:xxx},{id:2,name:xxx},{id:3,name:xxx},{id:4,name:xxx}
        ArrayList<Role> allRole = roleService.getAllRole();
        // 查询当前用户拥有角色id 2,4
        List<Integer> roleIds = roleService.getRoleIdByUserId(userid);
        for (Role role : allRole) {
            if (roleIds.contains(role.getId())) {
                assignRole.add(role);
            } else {
                unassignRole.add(role);
            }
        }
        model.addAttribute("assignRole", assignRole);
        model.addAttribute("unassignRole", unassignRole);
        return "assignRole";
    }

    /**
     * 分配角色
     */
    @ResponseBody
    @RequestMapping("addRoleByUserId")
    public String addRoleByUserId(QueryParam queryParam){
        roleService.addRoleByUserId(queryParam);
        return "";
    }

    /**
     * 移除角色
     */
    @ResponseBody
    @RequestMapping("removeRoleByUserId")
    public Result removeRoleByUserId(QueryParam queryParam) {
        Result result = new Result();
        try {
            roleService.removeRoleByUserId(queryParam);
            result.setState(true);
            result.setMsg("后台携带的数据");
        } catch (Exception e) {
            result.setState(false);
        } finally {

        }
        return result;
    }

    /**
     * 跳转页面
     */
    @RequiresPermissions(value = "query")
    @RequestMapping("toAssignPermission")
    public String toAssignPermission(Integer id){
        return "assignPermission";
    }

    /**
     * 授权
     */
    @ResponseBody
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(QueryParam queryParam){
        roleService.addPermissionToRole(queryParam);
        return "";
    }

    /**
     * 根据id查询（回显）
     */
    @RequestMapping("getById2")
    @ResponseBody
    public RolePermission getById2(Integer id){
        return roleService.getById2(id);
    }
}
