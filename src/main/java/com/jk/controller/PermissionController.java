package com.jk.controller;

import java.util.List;

import javax.annotation.Resource;

import com.jk.bean.Permission;
import com.jk.bean.QueryParam;
import com.jk.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("permission")
public class PermissionController {
	
	@Resource
	private PermissionService permissionService;
	
	/**
	 * 递归树（同步树）
	 */
	@RequestMapping("queryPermission")
	@ResponseBody
	public List<Permission> queryPermission(){
		return permissionService.queryPermission();
	}
	
	@ResponseBody
	@RequestMapping("queryTreeByRoleid")
	public  List<Permission> queryTreeByRoleid(QueryParam queryParam){
		return permissionService.queryTreeByRoleid(queryParam);
	}
}
