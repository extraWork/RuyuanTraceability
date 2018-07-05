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
	<title>角色管理</title>
	<link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
	<link rel="stylesheet" href="../../../yntree/yntree.min.css" media="all">
	<script type="text/javascript" src="../../../layuiadmin/layui/layui.js"></script>
	<script type="text/javascript" src="../../../layuiadmin/layui/layui.all.js"></script>
	<script type="text/javascript" src="../../../yntree/yntree.js"></script>
</head>
<body>
	<div class="layui-row layui-col-space5" style="margin:5px;margin-top:10px;">
		<div id="fullHeight" class="layui-col-md12">
				<div class="layui-form-item" style="margin-bottom:0px;">
				    <div class="layui-inline">
				      <label class="layui-form-label">角色名称：</label>
				      <div class="layui-input-inline">
				        <input id="rolename" class="layui-input">
				      </div>
				    </div>
				    <div class="layui-inline">
				      <label class="layui-form-label">角色编号：</label>
				      <div class="layui-input-inline">
				        <input id="rolecode" class="layui-input">
				      </div>
				    </div>
				    <div class="layui-inline">
		  			<button class="layui-btn" id="queryRole"><i class="layui-icon">&#xe615;</i>查询</button>
		  			<button class="layui-btn" id="addRole"><i class="layui-icon">&#xe608;</i>新增角色</button>
		  			<button class="layui-btn" id="deleteRole"><i class="layui-icon">&#xe640;</i>删除</button>
		  			</div>
				</div>
		</div>
  		<div class="layui-col-md12">
	  		<table id="roleTable" class="layui-hide" lay-filter="roleTable"></table>
  		</div>
	</div>
	
	<!-- 新增弹窗start -->
	<div id="roleDiv" style="display:none;padding:10px; ">
	<form id="roleForm" class="layui-form layui-form-pane" action="/userManager/saveUser">
		  <div class="layui-form-item">
		    <label class="layui-form-label">角色名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="rolename" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">角色编号</label>
		    <div class="layui-input-block">
		      <input type="text" name="rolecode" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">角色类型</label>
		    <div class="layui-input-block">
		      <select name="roletype" style="height:50px">
		        <option value="0" selected="">监管</option>
		        <option value="1">乳站</option>
		        <option value="2">乳企</option>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">描述</label>
		    <div class="layui-input-block">
		      <input type="text" name="roledesc" lay-verify="required|phone" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		</form>
	</div>
	<script type="text/html" id="barUser"><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a><a class="layui-btn layui-btn-xs" lay-event="resource">资源授权</a></script>
	<!-- 新增form end -->
	<!-- 资源授权 start -->
	<div id="resourceDiv" style="display:none;padding:10px; ">
		<fieldset class="layui-elem-field">
			<legend style="font-size:13px;margin-left:7px;">正在给 [<span id="resourceRoleName"></span>] 进行授权</legend>
		  	<div class="layui-field-box">
		   		<div id="tree" class=" fl tree"></div>
		  	</div>
		</fieldset>
	</div>
	<!-- 资源授权 end -->
	<script type="text/javascript">
        layui.config({
            base: '../../layuiadmin/' //静态资源所在路径
        }).use(['laydate','form','table','jquery'], function(){
        	 var laydate = layui.laydate,
         	  form = layui.form,
         	  table = layui.table,
         	  $ = layui.jquery;
        	 var roleDivLayer;
        	 //资源授权树变量
        	 var yntree;
        	 form.render();
        	 var height = $("#fullHeight").height()+35;
			 //表格渲染
        	 table.render({
        		    elem: '#roleTable',
        		    id:'roleTable',
        		    height:'full-'+height, //full为iframe高度,height为页面表格上面的各种参数条件的高度
        		    data:[],
        		    page:true,
        		    cols: [[
        		      {type:'checkbox'},
        		      {field:'rolename', title: '角色名称',minWidth:50},
        		      {field:'rolecode', title: '角色编号',minWidth:50},
        		      {field:'roledesc', title: '角色描述'},
        		      {field:'roletype', title: '角色类型',minWidth:90},
        		      {fixed: 'right', width:150, align:'center', toolbar: '#barUser'}
        		    ]]
        	  		,done:function(res,curr,count){
        	  			
        	  		}
        	 });
        	 //新增按钮
        	 $("#addRole").click(function(){
        		roleDivLayer =  layer.open({
         			title : '新增角色',
         			id:'roleDivLayer',
         			type : 1,
         			resize:false,
         			fixed:false,
         			move: false,
         			scrollbar:false,
         			content : $("#roleDiv"),
         			area:['380px','339px'],
         			btn:['保存','关闭'],
         			shade : 0.1,
         			yes:function(){
         				submitRole();
         			},
         			close:function(){
         				layer.close(this);
         			}
         		});
         	});
        	 //新增角色保存方法
        	 function submitRole(){
         		$.ajax({
                     //几个参数需要注意一下
                      type: "POST",//方法类型
                      dataType: "text",//预期服务器返回的数据类型
                      url: "/roleManager/saveRole" ,//url
                      data: $('#roleForm').serialize(),
                      success: function (result) {
                     	 if(result=="success"){
                     		 layer.msg("保存成功!");
                     		 layer.close(roleDivLayer);
                     		$("#queryRole").click();
                     	 }else{
                     		 layer.msg("保存失败,"+result);
                     	 }
                      }
                 });
              }
        	//查询按钮
        	$("#queryRole").click(function(){
        		table.reload('roleTable',{
        			url:'/roleManager/findRoleByParam',
        			where:{
        				rolename:$("#rolename").val(),
        				rolecode:$("#rolecode").val()
        			}
        		});
        	});
        	//删除按钮
        	$("#deleteUser").click(function(){
       			var data = table.checkStatus('usersTable').data;
       			if(data.length<=0){
       				layer.msg("请勾选用户再进行删除!");
       				return;
       			}
        		layer.confirm('是否确认删除?', {
       			  	btn: ['确认','关闭'] //按钮
       			}, function(index){
       				$.ajax({
                        //几个参数需要注意一下
                         type: "POST",//方法类型
                         dataType: "text",//预期服务器返回的数据类型
                         url: "/userManager/deleteUser" ,//url
                         data: JSON.stringify(data),
                         contentType:"application/json", // 指定这个协议很重要
                         success: function (result) {
                        	 if(result=="success"){
                        		layer.msg("删除成功!");
                        	 }else{
                        		layer.msg("删除失败,"+result);
                        	 }
                        	 layer.close(index);
                        	 $("#queryRole").click();
                         }
                    });
       			}, function(index){
       				layer.close(index);
       			});
        	});
        	//监听工具条
       	  	table.on('tool(roleTable)', function(obj){
       	    	var data = obj.data;
       	    	for (var p in data){
					$("#userForm").find(":input[name='" + p + "']").val(data[p]);
       	    	}
       	    	$("#userPwd").hide();
       	    	$("#userId").val(data.userId);
       	    	if(obj.event == 'edit'){
       	    		roleDivLayer= layer.open({
             			title : '编辑用户',
             			id:'editUserLayer',
             			type : 1,
             			resize:false,
             			fixed:false,
             			move: false,
             			scrollbar:false,
             			content : $("#addUserDiv"),
             			area:['380px','549px'],
             			btn:['保存','关闭'],
             			shade : 0.1,
             			yes:function(){
             				editUser();
             			},
             			close:function(){
             				layer.close(this);
             			}
             		});
       	    	}else if(obj.event == 'resource'){
       	    		showResourceDiv(data)
       	    	}
       	  	});
        	//显示资源授权div
        	function showResourceDiv(data){
        		$("#resourceRoleName").css("color","red");
        		$("#resourceRoleName").css("fontWeight","bold");
        		$("#resourceRoleName").html(data.rolename);
        		//先加载资源树
        		initResourceTree(data.roleid);
        		roleDivLayer = layer.open({
         			title : '资源授权',
         			id:'resourceDivLayer',
         			type : 1,
         			resize:false,
         			fixed:false,
         			move: false,
         			scrollbar:false,
         			content : $("#resourceDiv"),
         			area:['340px','460px'],
         			btn:['保存','关闭'],
         			shade : 0.1,
         			yes:function(){
         				saveRoleModule(data.roleid);
         			},
         			close:function(){
         				layer.close(this);
         			}
         		});
        	}
        	//保存角色菜单权限
        	function saveRoleModule(roleid){
        		var moduleIds = "";
        		$.each(yntree.getValues(),function(i, item) {
        			moduleIds+=item+",";
				});
        		$.ajax({
                    //几个参数需要注意一下
                     type: "POST",//方法类型
                     dataType: "text",//预期服务器返回的数据类型
                     url: "/roleManager/saveRoleModule" ,//url
                     data: {moduleIds:moduleIds,roleId:roleid},
                     success: function (result) {
                    	 if(result=="success"){
                    		 layer.msg("授权成功!");
                    		 layer.close(roleDivLayer);
                    		 $("#queryRole").click();
                    	 }else{
                    		 layer.msg("保存失败,"+result);
                    	 }
                     }
                });
        	}
        	//编辑
        	function editUser(){
        		$.ajax({
                    //几个参数需要注意一下
                     type: "POST",//方法类型
                     dataType: "text",//预期服务器返回的数据类型
                     url: "/userManager/editUser" ,//url
                     data: $('#userForm').serialize(),
                     success: function (result) {
                    	 if(result=="success"){
                    		 layer.msg("保存成功!");
                    		 layer.close(userLayer);
                    		$("#queryRole").click();
                    	 }else{
                    		 layer.msg("保存失败,"+result);
                    	 }
                     }
                });
        	}
        	//加载资源树
        	function initResourceTree(roleId){
        		//授权菜单数据
           		$.ajax({
                       //几个参数需要注意一下
                        type: "POST",//方法类型
                        dataType: "json",//预期服务器返回的数据类型
                        url: "/module/findModuleByAll" ,//url
                        success: function (result) {
                        	$("#tree").html("");
                        	var treeData = {
                        			// 复选框change事件
                        			onchange: function (input, yntree){
                        				//console.log(this);
                        			},
                        			// 是否严格的遵循父子互相关联的做法
                        			checkStrictly: true,
                        			data:result
                        	};
                        	yntree = new YnTree(document.getElementById("tree"), treeData);
                        	//展开两级菜单
                        	$.each(yntree.data,function(i, item) {
                        		item.spread(true);
                        		$.each(item.children,function(i, itemChildren){
                        			itemChildren.spread(true);
                        		});
                        	});
                        	//加载用户管理的资源信息
                        	findSysPermissionByRoleId(roleId);
                        }
    			});
        	}
        	//获取角色相关联的资源信息
        	function findSysPermissionByRoleId(roleId){
        		$.ajax({
                    //几个参数需要注意一下
                     type: "POST",//方法类型
                     dataType: "json",//预期服务器返回的数据类型
                     url: "/roleManager/findSysPermissionByRoleId" ,//url
                     data:{roleId:roleId},
                     success: function (result) {
                    	 $.each(result,function(i, item) {
                    		 yntree.select(item.modelid+"", true);
         				});
                     }
 				});
        	}
        });
    </script>
</body>
</html>