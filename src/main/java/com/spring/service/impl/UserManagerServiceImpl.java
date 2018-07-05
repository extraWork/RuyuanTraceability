package com.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.UserManagerDao;
import com.spring.domain.UserInfo;
import com.spring.service.UserManagerService;
import com.spring.util.DataGrid;
@Service
public class UserManagerServiceImpl implements UserManagerService{
	@Autowired
	private UserManagerDao userManagerDao;
	
	@Override
	public int saveUser(UserInfo userInfo) {
		return userManagerDao.saveUser(userInfo);
	}

	@Override
	public DataGrid<UserInfo> queryUserByParam(String userName, String userCode, String flag,int currentPage, int pageCount) {
		// TODO Auto-generated method stub
		PageHelper.startPage(currentPage, pageCount);
		List<UserInfo> userList = userManagerDao.queryUserByParam(userName,userCode,flag);
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(userList);
		DataGrid<UserInfo> dg = new DataGrid<UserInfo>();
		dg.setData(pageInfo.getList());
		dg.setCount(pageInfo.getTotal());
		dg.setPage(pageInfo.getPageNum());
		return dg;
	}

	@Override
	public void deleteUser(UserInfo[] users) {
		userManagerDao.deleteUser(users);
	}

	@Override
	public int editUser(UserInfo user) {
		return userManagerDao.editUser(user);
	}

	@Override
	public UserInfo login(String loginName, String loginPWD) {
		return userManagerDao.login(loginName,loginPWD);
	}

}
