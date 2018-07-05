package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.domain.UserInfo;
import com.spring.service.UserManagerService;
import com.spring.util.DataGrid;
import com.spring.util.ObjectUtil;

@Controller
@RequestMapping(value="userManager")
public class UserManagerController {
	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping(value = "/userManagerJump", method = RequestMethod.GET)
	public String userManagerJump(Model model , HttpServletRequest request) {
		return "SystemManager/userManager";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(UserInfo user , HttpServletRequest request) {
		user.setFlag(user.getFlag().equals("no")?"0":"1");
		user.setUserPWD(DigestUtils.md5Hex(user.getUserPWD()));
		userManagerService.saveUser(user);
		return "success";
	}
	
	@RequestMapping(value = "/queryUserByParam", method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<UserInfo> queryUserByParam(String userName , String userCode , String flag , @RequestParam(required=false)Integer limit,
    		@RequestParam(required=true,defaultValue="1")Integer page){
		return userManagerService.queryUserByParam(userName,userCode,flag,(page-1)*limit,limit);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(@RequestBody UserInfo [] users) {
		userManagerService.deleteUser(users);
		return "success";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	@ResponseBody
	public String editUser(UserInfo user , HttpServletRequest request) {
		user.setFlag(user.getFlag().equals("NO")?"0":"1");
		user.setUserPWD(null);
		userManagerService.editUser(user);
		return "success";
	}
}
