layui.config({
	base: '../layuiadmin/' //静态资源所在路径
}).use(['laydate','form','table','jquery'], function(){
	var laydate = layui.laydate,
	  form = layui.form,
	  table = layui.table,
	  $ = layui.jquery;
	var userLayer;
	form.render();
	initForm();
	var height = $("#fullHeight").height()+35;
	//初始化新增中角色下拉框数据 和 企业下拉框数据
	function initForm(){
		$.ajax({
			//几个参数需要注意一下
			type: "POST",//方法类型
			dataType: "json",//预期服务器返回的数据类型
			url: "/roleManager/findRoleByAll" ,//url
			success: function (result) {
				if(result.length<0){
					layer.msg("没有角色信息");
					return;
				}
				var option = "";
				$.each(result,function(i, item) {
					option+="<option value='"+item.roleid+"'>"+item.rolename+"</option>";
				});
				$("#selectRole").html(option);
				form.render("select");
			}
		});
	}
	//表格渲染
	table.render({
		elem: '#usersTable',
		id:'usersTable',
		height:'full-'+height, //full为iframe高度,height为页面表格上面的各种参数条件的高度
		data:[],
		page:true,
		cols: [[
			{type:'checkbox'},
			{field:'userName', title: '用户名称',minWidth:50},
			{field:'userCode', title: '登录名'},
			{field:'companyName', title: '所属企业名称',minWidth:90},
			{field:'roleName', title: '所属角色',minWidth:140},
			{field:'telephone', title: '联系电话',minWidth:80},
			{field:'email', title: '邮箱',minWidth:60},
			{field:'identifyNo', title: '识别号',minWidth:68},
			{field:'flag', title: '是否启用',minWidth:60},
			{field:'createDate', title: '创建时间',minWidth:60},
			{fixed: 'right', width:150, align:'center', toolbar: '#barUser'}
		]]
		,done:function(res,curr,count){
		  			
  		}
	});
	//新增按钮
    $("#addUser").click(function(){
    	$("#userPwd").show();
        userLayer =  layer.open({
        	title : '新增用户',
 			id:'addUserLayer',
 			type : 1,
 			resize:false,
 			fixed:false,
 			move: false,
 			scrollbar:false,
 			content : $("#addUserDiv"),
 			area:['380px','599px'],
 			btn:['保存','关闭'],
 			shade : 0.1,
 			yes:function(){
 				submitUser();
 			},
 			close:function(){
 				layer.close(this);
 			},
 			end: function(index, layero){
 				cleanForm("userForm");
				$("#selectRole").val("");
				$("#selectCompany").val("");
				form.render("select");
 			}
        });
 	});
    //新增用户保存方法
    function submitUser(){
    	$.ajax({
    		//几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "text",//预期服务器返回的数据类型
            url: "/userManager/saveUser" ,//url
            data: $('#userForm').serialize(),
            success: function (result) {
            	if(result=="success"){
            		layer.msg("保存成功!");
            		layer.close(userLayer);
            		$("#queryUser").click();
            	}else{
            		layer.msg("保存失败,"+result);
            	}
            }
    	});
	}
	//查询按钮
	$("#queryUser").click(function(){
		table.reload('usersTable',{
			url:'/userManager/queryUserByParam',
			where:{
				userName:$("#userName").val(),
				userCode:$("#userCode").val(),
				flag:$("#flag").val()
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
					$("#queryUser").click();
				}
			});
		}, function(index){
			layer.close(index);
		});
	});
	//监听工具条
	table.on('tool(usersTable)', function(obj){
		var data = obj.data;
		for (var p in data){
			$("#userForm").find(":input[name='" + p + "']").val(data[p]);
		}
    	$("#userPwd").hide();
    	$("#userId").val(data.userId);
    	$("#selectRole").val(data.roleId);
    	$("#selectCompany").val(data.companyId);
		form.render("select");
    	if(obj.event == 'edit'){
    		userLayer= layer.open({
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
     			},
     			end: function(index, layero){
     				cleanForm("userForm");
					$("#selectRole").val("");
					$("#selectCompany").val("");
					form.render("select");
     			}
     		});
    	}
  	});
	//角色下拉框选中监听
	form.on('select(selectRole)', function(data){
		$("#roleId").val(data.value)
		$("#roleName").val(data.elem.options[data.elem.selectedIndex].text);
	});
	form.on('select(selectCompany)', function(data){
		$("#companyId").val(data.value)
		$("#companyName").val(data.elem.options[data.elem.selectedIndex].text);
	});
	//编辑用户信息保存按钮
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
					$("#queryUser").click();
				}else{
					layer.msg("保存失败,"+result);
				}
			}
		});
	}
	
	function cleanForm(formId){
		$.each($("#"+formId).find("input[name]"),function(i,item){
			$(item).val("");
		});
	}
});