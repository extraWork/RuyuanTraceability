<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<title>用户管理</title>
	<link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
	<script type="text/javascript" src="../../../layuiadmin/layui/layui.js"></script>
	<script type="text/javascript" src="../../../layuiadmin/layui/layui.all.js"></script>
</head>
<body>
	<div class="layui-row layui-col-space5" style="margin:5px;margin-top:10px;">
		<div id="fullHeight" class="layui-col-md12">
				<div class="layui-form-item" style="margin-bottom:0px;">
				    <div class="layui-inline">
				      <label class="layui-form-label">登录名：</label>
				      <div class="layui-input-inline">
				        <input id="userCode" class="layui-input">
				      </div>
				    </div>
				    <div class="layui-inline">
				      <label class="layui-form-label">真实姓名：</label>
				      <div class="layui-input-inline">
				        <input id="userName" class="layui-input">
				      </div>
				    </div>
				    <div class="layui-inline layui-form">
				      	<label class="layui-form-label">状态：</label>
					    <div class="layui-input-inline">
					      <select id="flag">
					        <option value="">全部</option>
					        <option value="0">启用</option>
					        <option value="1">禁用</option>
					      </select>
					    </div>
				    </div>
				    <div class="layui-inline">
		  			<button class="layui-btn" id="queryUser"><i class="layui-icon">&#xe615;</i>查询</button>
		  			<button class="layui-btn" id="addUser"><i class="layui-icon">&#xe608;</i>新增用户</button>
		  			<button class="layui-btn" onclick="query()"><i class="layui-icon">&#xe673;</i>重置密码</button>
		  			<button class="layui-btn" id="deleteUser"><i class="layui-icon">&#xe640;</i>删除</button>
		  			</div>
				</div>
		</div>
  		<div class="layui-col-md12">
	  		<table id="usersTable" class="layui-hide" lay-filter="usersTable"></table>
  		</div>
	</div>
	
	<!-- 新增、编辑弹窗start -->
	<div id="addUserDiv" style="display:none;padding:10px; ">
	<form id="userForm" class="layui-form layui-form-pane" action="/userManager/saveUser">
		  <div class="layui-form-item">
		    <label class="layui-form-label">用户名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="userName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		      <input type="text" style="display:none;" id="userId" name="userId" value="0">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">登录名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="userCode" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div id="userPwd" class="layui-form-item">
		    <label class="layui-form-label">密码</label>
		    <div class="layui-input-block">
		      <input type="password" name="userPWD" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">所属企业</label>
		    <div class="layui-input-block">
		      <select id="selectCompany" lay-filter="selectCompany" style="height:50px">
		        <option value="0" selected="">菜单</option>
		        <option value="1">按钮</option>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">所属角色</label>
		    <div class="layui-input-block">
		      <input id="roleId" name="roleId" type="hidden">
		      <input id="roleName" name="roleName" type="hidden">
		      <select id="selectRole" lay-filter="selectRole" style="height:50px">
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">联系电话</label>
		    <div class="layui-input-block">
		      <input type="text" name="telephone" lay-verify="required|phone" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">邮箱</label>
		    <div class="layui-input-block">
		      <input type="text" name="email" lay-verify="email" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">识别号</label>
		    <div class="layui-input-block">
		      <input type="text" name="identifyNo" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item" pane="">
		    <label class="layui-form-label">是否启用</label>
		    <div class="layui-input-block">
		      <input type="checkbox" checked="" name="flag" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF" title="开关">
		    </div>
		  </div>
		</form>
	</div>
	<script type="text/html" id="barUser"><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a></script>
	<!-- 新增、编辑 end -->
	<script type="text/javascript" src="../../../js/userManager.js"></script>
</body>
</html>