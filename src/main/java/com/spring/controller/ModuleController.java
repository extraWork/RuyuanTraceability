package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.domain.ModuleInfo;
import com.spring.domain.TreeNode;
import com.spring.domain.ModuleInfo;
import com.spring.service.ModuleService;
import com.spring.util.ObjectUtil;
import com.spring.util.TreeUtil;

/**
 * 资源管理controller类
 * @author Fantasyo
 *
 */
@Controller
@RequestMapping(value="module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value = "/queryModule", method = RequestMethod.GET)
    @ResponseBody
    public List<ModuleInfo> queryModule(String moduleParent) {
        return moduleService.queryModule(moduleParent, null);
    }
	
	@RequestMapping(value = "/systemModuleJump", method = RequestMethod.GET)
	public String systemModuleJump(Model model , HttpServletRequest request) {
		model.addAttribute("moduleInfoList", moduleService.queryModule(null, "1"));
		return "SystemManager/systemModule";
	}

	@RequestMapping(value = "/saveSystemModule", method = RequestMethod.GET)
	public String saveSystemModule(ModuleInfo moduleInfo,Model model , HttpServletRequest request) {
		moduleService.saveSystemModule(moduleInfo);
		return systemModuleJump(model, request);
	}
	
	
	
	/**
	 * 查询所有资源信息
	 * @return
	 */
	@RequestMapping(value = "/findModuleByAll", method = RequestMethod.POST)
    @ResponseBody
	public List<TreeNode> findModuleByAll(){
		List<ModuleInfo> moduleList = moduleService.queryModule(null, null);
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (ModuleInfo moduleInfo : moduleList) {
			TreeNode node = new TreeNode();
			node.setInputName(moduleInfo.getModuleId()+"");
			node.setValue(moduleInfo.getModuleId()+"");
			node.setParentValue(moduleInfo.getModuleParent());
			node.setName(moduleInfo.getModuleName());
			nodeList.add(node);
		}
		return TreeUtil.bulid(nodeList);
	}
}
