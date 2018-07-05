package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.SysPermissionMapper;
import com.spring.dao.SysRoleMapper;
import com.spring.domain.SysPermission;
import com.spring.domain.SysRole;
import com.spring.domain.UserInfo;
import com.spring.service.RoleManagerService;
import com.spring.util.DataGrid;
@Service
public class RoleManagerServiceImpl implements RoleManagerService{
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Override
	public int saveRole(SysRole role) {
		return sysRoleMapper.insert(role);
	}

	@Override
	public DataGrid<SysRole> findRoleByParam(String rolename, String rolecode, int page, Integer limit) {
		PageHelper.startPage(page, limit);
		List<SysRole> roleList = sysRoleMapper.findRoleByParam(rolecode, rolename);
		PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(roleList);
		DataGrid<SysRole> dg = new DataGrid<SysRole>();
		dg.setData(pageInfo.getList());
		dg.setCount(pageInfo.getTotal());
		dg.setPage(pageInfo.getPageNum());
		return dg;
	}

	@Override
	public List<SysRole> findRoleByAll() {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectAll();
	}

	@Override
	public int saveRoleModule(List<String> moduleIds, String roleId) {
		sysPermissionMapper.deleteRoleModule(roleId);
		
		return sysPermissionMapper.saveRoleModule(moduleIds,roleId);
	}
	
	@Override
	public List<SysPermission> findSysPermissionByRoleId(String roleId){
		return sysPermissionMapper.findSysPermissionByRoleId(roleId);
	}

}
