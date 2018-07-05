<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" type="text/css" href="../../../easyui/gxt-all.css" />
	<link rel="stylesheet" type="text/css" href="../../../easyui/index.css" />
	<link rel="stylesheet" type="text/css" href="../../../easyui/blue.css" />
	<link rel="stylesheet" type="text/css" href="../../../easyui/main.css" />
	<link rel="stylesheet" type="text/css" href="../../../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../../../easyui/demo.css">
	<script language="javascript" type="text/javascript"
		src="../../../easyui/js/jquery.min.js"></script>
	<script language="javascript" type="text/javascript"
		src="../../../easyui/js/jquery.easyui.min.js"></script>
</head>
<body>
	<div class="layui-fluid">
    	<div class="layui-row layui-col-space15">
      		<div class="layui-col-md12">
        		<div class="layui-card">
          			<div class="layui-card-header">数据操作</div>
          			<div class="layui-card-body">
	            		<div class="layui-btn-group test-table-operate-btn" style="margin-bottom: 10px;">
	              			<button class="layui-btn" data-type="getCheckLength">新增菜单</button>
	            		</div>
	            		<div>
	            			<div id="ttResource" class="easyui-tabs"   tabPosition="bottom" data-options="region:'center',split:false" style="width: 80%; height: 100%;"></div>
	            		</div>
					</div>
       			</div>
      		</div>
    	</div>
  	</div>
  	<script>
  	ajax();
  	function ajax(){
  		$.ajax({
  			type: "GET",
  			url : "test",
  			dataType: "json",
  			success : function(map) {
  				if (map) {
  					$.each(map.rows, function(i, item) {
  						addTab(item);
  					});
  					//设置点击事件
  					$("#ttResource").tabs({
  					    border:false,
  					    onSelect:function(title){
  					    	var id=$("#ttResource").tabs("getSelected").panel("options").id;
  							var name=$("#ttResource").tabs("getSelected").panel("options").title;
  							$("#table[title='"+name+"']").treegrid({url:url+id,
  								onLoadSuccess:function(){
  									//$("#table[title='"+name+"']").treegrid('collapseAll');
  								}	
  							});		
  					    }
  					});
  					
  				} else {
  					alert("数据获取失败,请检查网络");
  				}
  			}
  		});
  	}
  //动态创建tabs
	function addTab(title){
		if ($("#ttResource").tabs("exists", title.name)) {
			$("#ttResource").tabs("select", title.name);
		} else {
			 var content="<table class=\"easyui-treegrid\" id=\"table\" data-options=\"collapsed:\'true\',checkbox:\'true\',initialState:\'collapsed\',onClickRow:onClick,method: \'get\',treeField:\'name\',idField:\'id\'\"  style=\"height: 100%\" title=\""+title.name+"\"  style=\"margin:20px 0 10px 0;\" toolbar=\"#toolbar"+title.id+"\" rownumbers=\"true\" fitColumns=\"true\"singleSelect=\"true\"  ><thead><tr>"
			  +"<th data-options=\"field:\'id\'\" hidden=\"true\">主键</th>" 
			+"<th data-options=\"field:\'name\'\" width=\"50\">名称</th>"
			+"<th data-options=\"field:\'code\'\" width=\"50\">编码</th>"
			+"<th data-options=\"field:\'resourceTypeCode\'\" width=\"50\">资源类型</th> " 
			+"</tr></thead></table><div id=\"toolbar"+title.id+"\"><a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"newRM()\">新增</a><a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onclick=\"editRM()\">编辑</a><a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onclick=\"removeRM()\">删除</a><a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\" onclick=\"reloadRM()\">刷新</a></div>";
 			$("#ttResource").tabs("add", {
				title : title.name,
				id:title.id,
				content : content,
				closable : false
			});
		}
	}
  	</script>
</body>
</html>