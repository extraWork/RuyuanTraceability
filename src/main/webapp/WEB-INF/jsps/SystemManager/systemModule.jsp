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
	<title>菜单</title>
	<link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
	<script type="text/javascript" src="../../../layuiadmin/layui/layui.js"></script>
	<script type="text/javascript" src="../../../layuiadmin/layui/layui.all.js"></script>
	<script src="../../../treeTable/jquery.js"></script>
	<script src="../../../treeTable/jquery.treeTable.js"></script> 
</head>
<body>
	<div class="layui-row layui-col-space5" style="margin:5px;margin-top:10px;">
		<div class="layui-col-md12">
			<div class="layui-btn-group test-table-operate-btn">
		  		<button class="layui-btn" id="addModule">新增</button>
		  		<button class="layui-btn" onclick="query()">刷新</button>
		  	</div>
		</div>
  		<div class="layui-col-md12">
	  		<table id="treeTable1" lay-size="sm" style="margin:0px 0px 0px 0px"  class="layui-table" style="width: 100%">
	  			<thead>
				    <tr>
				        <td style="width:20%">菜单名称</td>
				        <td style="width:30%">url</td>
				        <td style="width:15%">类型</td>
				        <td style="width:15%">序号</td>
				        <td style="width:20%">操作</td>
				    </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="item" items="${moduleInfoList}">
				    	<tr hasChild="true" id="${item.moduleId}">
				    		<td><span controller="true">${item.moduleName}</span></td>
					        <td>${item.moduleURL}</td>
					        <td>${item.moduleType}</td>
					        <td>${item.moduleNo}</td>
					        <td><button class="layui-btn layui-btn-sm" onclick="editModule('${item.moduleId}','${item.moduleName}','${item.moduleURL}','${item.moduleType}','${item.moduleNo}','${item.moduleParent}')">编辑</button><button class="layui-btn layui-btn-sm" onclick="query()">删除</button>
		  					</td>
				    	</tr>
			    	</c:forEach>
			    </tbody>
			</table>
  		</div>
	</div>
	<!-- 新增弹窗start -->
	<div id="addModuleForm" style="display:none;padding:10px; ">
	<form id="moduleForm" class="layui-form layui-form-pane" action="/module/saveSystemModule">
		  <div class="layui-form-item">
		    <label class="layui-form-label">菜单名称</label>
		    <div class="layui-input-block">
		      <input type="text" id="moduleName" name="moduleName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">上级菜单</label>
		    <div class="layui-input-block">
		      <div id="topMenu" class="layui-unselect layui-form-select">
		      	<div class="layui-select-title">
		      		<input id="topMenuInput" type="text" readonly="" class="layui-input layui-unselect"><i class="layui-edge"></i>
		      		<input id="moduleParent" name="moduleParent" style="display:none" >
		      		<input id="moduleId" name="moduleId" style="display:none" >
		      	</div>
	      	  </div>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">类型</label>
		    <div class="layui-input-block">
		      <select id="moduleType" name="moduleType" style="height:50px">
		        <option value="0" selected="">菜单</option>
		        <option value="1">按钮</option>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">URL</label>
		    <div class="layui-input-block">
		      <input type="text" id="moduleURL" name="moduleURL" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">序号</label>
		    <div class="layui-input-block">
		      <input type="text" id="moduleNo" name="moduleNo" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		</form>
		<!-- 新增菜单中上级菜单下拉框div start-->
		<div id="treeTableSelect" style="display:none;height:180px;background-color:#fff;overflow-y: scroll" class="layui-col-md12">
	  		<table id="treeTableSelect" onclick="topMenuClick()" lay-size="sm" style="margin:0px 0px 0px 0px;"  class="layui-table">
			    <tbody>
			    	<c:forEach var="item" items="${moduleInfoList}">
				    	<tr hasChild="true" id="${item.moduleId}">
				    		<td><span controller="true">${item.moduleName}</span></td>
				    		<td><button class="layui-btn layui-btn-sm" onclick="clickMenu('${item.moduleId}','${item.moduleName}')">选择</button></td>
				    	</tr>
			    	</c:forEach>
			    </tbody>
			</table>
 		</div>
		<!-- 新增菜单中上级菜单下拉框div end-->
	</div>
	<!-- 新增form end -->
	<script type="text/javascript">
        $(function(){
            var option = {
                theme:'vsStyle',
                expandLevel : 1,
                beforeExpand : function($treeTable, id) {
                    //判断id是否已经有了孩子节点，如果有了就不再加载，这样就可以起到缓存的作用
                    if ($('.' + id, $treeTable).length) { return; }
                    $.ajax({
        	  			type: "GET",
        	  			url : "/module/queryModule",
        	  			dataType: "json",
        	  			data : {
        	  				moduleParent: id
	    				},
        	  			success : function(data) {
        	  				if(data){
        	  					var html = '';
        	  					$.each(data,function(i, item) {
        	  						html += '<tr hasChild="true" id="'+item.moduleId+'" pId="'+item.moduleParent+'">'
        	  						+'<td>'+item.moduleName+'</td><td>'+item.moduleURL+'</td><td>'+item.moduleType+'</td><td>'+item.moduleNo+'</td>'
        	  						+'<td><button class="layui-btn layui-btn-sm" onclick="editModule(\''+item.moduleId+'\',\''+item.moduleName+'\',\''+item.moduleURL+'\',\''+item.moduleType+'\',\''+item.moduleNo+'\',\''+item.moduleParent+'\')">编辑</button><button class="layui-btn layui-btn-sm" onclick="query()">删除</button></td></tr>';
        	  					});
                    			$treeTable.addChilds(html);
        	  				}
        	  			}
        	  		});
                },
                onSelect : function($treeTable, id) {
                    console.log('onSelect:' + id);
                }
            };
            var treeTableSelect = {
                    theme:'vsStyle',
                    expandLevel : 1,
                    beforeExpand : function($treeTable, id) {
                    	//判断id是否已经有了孩子节点，如果有了就不再加载，这样就可以起到缓存的作用
                        if ($('.' + id, $treeTable).length) { return; }
                        $.ajax({
            	  			type: "GET",
            	  			url : "/module/queryModule",
            	  			dataType: "json",
            	  			data : {
            	  				moduleParent: id
    	    				},
            	  			success : function(data) {
            	  				if(data){
            	  					var html = '';
            	  					$.each(data,function(i, item) {
            	  						html += '<tr hasChild="true" id="'+item.moduleId+'" pId="'+item.moduleParent+'">'
            	  						+'<td>'+item.moduleName+'</td><td><button class="layui-btn layui-btn-sm" onclick="clickMenu(\''+item.moduleId+'\',\''+item.moduleName+'\')">选择</button></td></tr>';
            	  					});
                        			$treeTable.addChilds(html);
            	  				}
            	  			}
            	  		});
                    },
                    onSelect : function($treeTable, id) {
                        window.console && console.log('onSelect:' + id);
                    }
                };
            $('#treeTable1').treeTable(option);
            $('#treeTableSelect').treeTable(treeTableSelect);
        });
        
        layui.config({
            base: '../../layuiadmin/' //静态资源所在路径
        }).use(['laydate','form','table','jquery'], function(){
        	 var laydate = layui.laydate,
         	  form = layui.form,
         	  table = layui.table,
         	  $ = layui.jquery;
        	 form.render();
        	$("#addModule").click(function(){
        		var tempLayer =  layer.open({
        			title : '新增模块',
        			id:'queryDeptTemp',
        			type : 1,
        			resize:false,
        			fixed:false,
        			move: false,
        			scrollbar:false,
        			content : $("#addModuleForm"),
        			area:['400px','410px'],
        			btn:['保存','关闭'],
        			shade : 0.1,
        			yes:function(){
        				$("#moduleForm").submit();
        			},
        			close:function(){
        				$("addModuleForm")
        				layer.close(this);
        			}
        		});
        	});
        	
        	$("#topMenu").click(function(){
				if($("#topMenu").attr("class")=="layui-unselect layui-form-select layui-form-selected"){
					$("#topMenu").attr("class","layui-unselect layui-form-select");
					$("#treeTableSelect").hide();
				}else{
	        		$("#topMenu").attr("class","layui-unselect layui-form-select layui-form-selected");
	        		var width = $("#topMenu").width();
	        		var offset = $("#topMenu").offset();
					$("#treeTableSelect").css({'position':"fixed",'top':offset.top+40,'left':offset.left,'width':width,'z-index':9999999999999999});
					$("#treeTableSelect").show();
				}
        	});
        	$("#topMenuInput").blur(function(){
        		setTimeout('blurSelect()', 150);
        	});
        	function editModule(){
        		alert();
        	}
        });
        //编辑
        function editModule(moduleId,moduleName,moduleURL,moduleType,moduleNo,moduleParent){
			$("#moduleId").val(moduleId);
			$("#moduleName").val(moduleName);
			$("#moduleURL").val(moduleURL);
			$("#moduleType").val(moduleType);
			$("#moduleNo").val(moduleNo);
			$("#moduleParent").val(moduleParent);
			<input id="topMenuInput" type="text" readonly="" class="layui-input layui-unselect"><i class="layui-edge"></i>
			layui.config({
	            base: '../../layuiadmin/' //静态资源所在路径
	        }).use(['laydate','form','table','jquery'], function(){
	        	var laydate = layui.laydate,
	         	  form = layui.form,
	         	  table = layui.table,
	         	  $ = layui.jquery;
	        	 form.render();
	        	$("#moduleForm").attr("action","/module/editSystemModule")
	        	var tempLayer =  layer.open({
        			title : '编辑模块',
        			id:'queryDeptTemp',
        			type : 1,
        			resize:false,
        			fixed:false,
        			move: false,
        			scrollbar:false,
        			content : $("#addModuleForm"),
        			area:['400px','410px'],
        			btn:['保存','关闭'],
        			shade : 0.1,
        			yes:function(){
        				$("#moduleForm").submit();
        			},
        			close:function(){
        				layer.close(this);
        			}
        		});
	        });
        }
        
        function blurSelect(){
    		if($("#topMenu").attr("flag")=="1"){
    			$("#topMenu").attr("class","layui-unselect layui-form-select layui-form-selected");
    			$("#topMenu").attr("flag","0");
    			return;
    		}
    		$("#topMenu").attr("class","layui-unselect layui-form-select");
    		$("#treeTableSelect").hide();
    	}
        
        function topMenuClick(){
        	$("#topMenuInput").focus();
        	$("#topMenu").attr("class","layui-unselect layui-form-select layui-form-selected");
        	$("#topMenu").attr("flag","1");
        }
        
        function clickMenu(moduleId,name){
        	$("#topMenuInput").val(name);
        	$("#moduleParent").val(moduleId);
        	setTimeout('$("#topMenu").click()', 180);
        }
        
    </script>
</body>
</html>