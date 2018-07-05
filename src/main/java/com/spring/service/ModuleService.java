package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.domain.ModuleInfo;
public interface ModuleService {
	/**
	 * 查询菜单
	 * @param moduleParent
	 * @param isParent
	 * @return
	 */
	public List<ModuleInfo> queryModule(String moduleParent,String isParent);
	/**
	 * 新增菜单信息
	 * @param moduleInfo
	 */
	public void saveSystemModule(ModuleInfo moduleInfo);
	/**
	 * 根据角色Id查询相关的资源信息
	 * @param roleId
	 * @return
	 */
	public List<ModuleInfo> findModuleByRoleId(int roleId);
}
