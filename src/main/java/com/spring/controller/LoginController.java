package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.ModuleInfo;
import com.spring.domain.TreeNode;
import com.spring.domain.UserInfo;
import com.spring.service.ModuleService;
import com.spring.service.UserManagerService;
import com.spring.util.TreeUtil;

@Controller
public class LoginController {
	@Autowired
	private UserManagerService userManagerService;
	@Autowired
	private ModuleService moduleService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginJump(){
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String loginName , String loginPWD , HttpServletRequest request){
		loginPWD = DigestUtils.md5Hex(loginPWD);
		//查询用户信息
		UserInfo user = userManagerService.login(loginName,loginPWD);
		//查询用户角色相关的资源信息
		List<ModuleInfo> moduleList = moduleService.findModuleByRoleId(user.getRoleId());
		//获取session
		HttpSession session = request.getSession();
		session.setAttribute("menu", moduleList);
		session.setAttribute("user", user);
		return "index";
	}
	
}
