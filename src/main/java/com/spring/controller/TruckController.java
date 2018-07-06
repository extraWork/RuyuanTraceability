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
import com.spring.domain.Truck;
import com.spring.domain.UserInfo;
import com.spring.service.CompanyinfoService;
import com.spring.service.TruckService;
import com.spring.service.UserManagerService;
import com.spring.util.DataGrid;
import com.spring.util.ObjectUtil;

@Controller
@RequestMapping(value="truckinfo")
public class TruckController {
	@Autowired
	private TruckService truckservice;
	
	// 跳转到公司信息主页面
	@RequestMapping(value = "/truckManagerJump", method = RequestMethod.GET)
	public String userManagerJump(Model model , HttpServletRequest request) {
		return "SystemManager/userManager";
	}
	
	// 保存
	@RequestMapping(value = "/addTruck", method = RequestMethod.POST)
	@ResponseBody
	public String saveTruck(Truck record , HttpServletRequest request) {
		truckservice.insert(record);
		return "success";
	}
	
	// 分页且模糊查询
	@RequestMapping(value = "/queryTruckByParam", method = RequestMethod.GET)
	@ResponseBody
	public DataGrid<Truck> queryTruckByParam(Truck truck , @RequestParam(required=false)Integer limit,
    		@RequestParam(required=true,defaultValue="1")Integer page){
		return truckservice.selectByPrimaryKey(truck,(page-1)*limit,limit);
	}
	
	// 删除信息
	@RequestMapping(value = "/deleteTruck", method = RequestMethod.POST)
	@ResponseBody
	public String deleteTruck(@RequestBody  Truck [] truck) {
		truckservice.delete(truck);
		return "success";
	}
	
	// 修改信息
	@RequestMapping(value = "/editTruck", method = RequestMethod.POST)
	@ResponseBody
	public String editTruck(Truck truck , HttpServletRequest request) {
		truckservice.update(truck);
		return "success";
	}
}
