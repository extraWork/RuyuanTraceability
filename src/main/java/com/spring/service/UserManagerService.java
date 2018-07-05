package com.spring.service;

import java.util.List;
import com.spring.domain.UserInfo;
import com.spring.util.DataGrid;

public interface UserManagerService {
	/**
	 * 新增用户
	 * @param userInfo 用户信息
	 */
	public int saveUser(UserInfo userInfo);
	/**
	 * 根据参数查询用户集合
	 * @param userName 用户名称
	 * @param userCode 登录名称
	 * @param flag 状态
	 * @return
	 */
	public DataGrid<UserInfo> queryUserByParam(String userName, String userCode, String flag, int currentPage, int pageCount);
	/**
	 * 删除用户信息
	 * @param users
	 */
	public void deleteUser(UserInfo[] users);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public int editUser(UserInfo user);
	/**
	 * 根据用户名和密码查询用户信息
	 * @param loginName
	 * @param loginPWD
	 * @return
	 */
	public UserInfo login(String loginName, String loginPWD);
}
