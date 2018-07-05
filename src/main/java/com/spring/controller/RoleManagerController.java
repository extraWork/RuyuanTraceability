package com.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.SysPermission;
import com.spring.domain.SysRole;
import com.spring.domain.UserInfo;
import com.spring.service.RoleManagerService;
import com.spring.util.DataGrid;

@Controller
@RequestMapping(value="roleManager")
public class RoleManagerController {
	@Autowired
	private RoleManagerService roleManagerService;
	
	@RequestMapping(value = "/roleManagerJump", method = RequestMethod.GET)
	public String roleManagerJump(Model model , HttpServletRequest request) {
		return "SystemManager/roleManager";
	}
	
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	@ResponseBody
	public String saveRole(SysRole role) {
		int result = roleManagerService.saveRole(role);
		if(result>0) {
			return "success";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value = "/findRoleByParam", method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<SysRole> findRoleByParam(String rolename , String rolecode , @RequestParam(required=false)Integer limit,
    		@RequestParam(required=true,defaultValue="1")Integer page){
		return roleManagerService.findRoleByParam(rolename,rolecode,(page-1)*limit,limit);
	}
	
	@RequestMapping(value = "/findRoleByAll", method = RequestMethod.POST)
	@ResponseBody
	public List<SysRole> findRoleByAll(){
		return roleManagerService.findRoleByAll();
	}
	
	/**
	 * 保存角色关联的资源信息
	 * @return
	 */
	@RequestMapping(value = "/saveRoleModule", method = RequestMethod.POST)
	@ResponseBody
	public String saveRoleModule(String moduleIds, String roleId) {
		List<String> moduleIdList = Arrays.asList(moduleIds.split(","));
		int result = roleManagerService.saveRoleModule(moduleIdList,roleId);
		if(result>0) {
			return "success";
		}else {
			return "error";
		}
	}
	/**
	 * 查询角色关联的资源信息
	 * @return
	 */
	@RequestMapping(value = "/findSysPermissionByRoleId", method = RequestMethod.POST)
	@ResponseBody
	public List<SysPermission> findSysPermissionByRoleId(String roleId) {
		return roleManagerService.findSysPermissionByRoleId(roleId);
	}
}
