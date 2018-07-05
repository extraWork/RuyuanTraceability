package com.spring.service;

import java.util.List;

import com.spring.domain.SysPermission;
import com.spring.domain.SysRole;
import com.spring.util.DataGrid;

public interface RoleManagerService {
	/**
	 * 新增角色
	 * @param role 角色信息
	 * @return
	 */
	public int saveRole(SysRole role);
	/**
	 * 根据条件查询角色信息
	 * @param rolename
	 * @param rolecode
	 * @param page
	 * @param limit
	 * @return
	 */
	public DataGrid<SysRole> findRoleByParam(String rolename, String rolecode, int page, Integer limit);
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<SysRole> findRoleByAll();
	/**
	 * 保存角色关联的资源信息
	 * @return
	 */
	public int saveRoleModule(List<String> moduleIds, String roleId);
	/**
	 * 根据角色ID查询相关联的资源信息
	 * @param roleId
	 * @return
	 */
	public List<SysPermission> findSysPermissionByRoleId(String roleId);
	
}
