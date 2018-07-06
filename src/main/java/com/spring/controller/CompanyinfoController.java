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

import com.spring.domain.Companyinfo;
import com.spring.domain.UserInfo;
import com.spring.service.CompanyinfoService;
import com.spring.service.UserManagerService;
import com.spring.util.DataGrid;
import com.spring.util.ObjectUtil;

@Controller
@RequestMapping(value="companyInfo")
public class CompanyinfoController {
	@Autowired
	private CompanyinfoService companyinfoService;
	
	// 跳转到公司信息主页面
	@RequestMapping(value = "/userManagerJump", method = RequestMethod.GET)
	public String userManagerJump(Model model , HttpServletRequest request) {
		return "SystemManager/userManager";
	}
	
	// 保存
	@RequestMapping(value = "/addCompanyinfo", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(Companyinfo companyinfo , HttpServletRequest request) {
		companyinfoService.insert(companyinfo);
		return "success";
	}
	
	// 分页且模糊查询
	@RequestMapping(value = "/queryCompanyinfoByParam", method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<Companyinfo> queryCompanyinfoByParam(Companyinfo companyinfo , @RequestParam(required=false)Integer limit,
    		@RequestParam(required=true,defaultValue="1")Integer page){
		return companyinfoService.selectByPrimaryKey(companyinfo,(page-1)*limit,limit);
	}
	
	// 删除信息
	@RequestMapping(value = "/deleteCompanyinfo", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(@RequestBody Companyinfo [] companys) {
		companyinfoService.deleteByPrimaryKey(companys);
		return "success";
	}
	
	// 修改信息
	@RequestMapping(value = "/editCompany", method = RequestMethod.POST)
	@ResponseBody
	public String editUser(Companyinfo companyinfo , HttpServletRequest request) {
		companyinfoService.updateByPrimaryKey(companyinfo);
		return "success";
	}
}
