package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ModuleDao;
import com.spring.domain.ModuleInfo;
import com.spring.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public List<ModuleInfo> queryModule(String moduleParent,String isParent) {
		// TODO Auto-generated method stub
		return moduleDao.queryModule(moduleParent, isParent);
	}

	@Override
	public void saveSystemModule(ModuleInfo moduleInfo) {
		// TODO Auto-generated method stub
		moduleDao.addModule(moduleInfo);
		
	}

	@Override
	public List<ModuleInfo> findModuleByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return moduleDao.findModuleByRoleId(roleId);
	}
	
}
