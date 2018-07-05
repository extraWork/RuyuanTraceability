<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<link id="layuicss-layer" rel="stylesheet" href="../layuiadmin/layui/css/modules/layer/default/layer.css" media="all">
	<meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuiadmin/style/admin.css" media="all">
</head>
<body class="layui-layout-body">
  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect>
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
            </a>
          </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
          
          <li class="layui-nav-item" lay-unselect>
            <a lay-href="app/message/index.html" layadmin-event="message" lay-text="消息中心">
              <i class="layui-icon layui-icon-notice"></i>  
              <!-- 如果有新消息，则显示小圆点 -->
              <span class="layui-badge-dot"></span>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="note">
              <i class="layui-icon layui-icon-note"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="fullscreen">
              <i class="layui-icon layui-icon-screen-full"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;">
              <cite>${user.userName}</cite>
            </a>
            <dl class="layui-nav-child">
              <dd><a lay-href="set/user/info.html">基本资料</a></dd>
              <dd><a lay-href="set/user/password.html">修改密码</a></dd>
              <hr>
              <dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>
            </dl>
          </li>
          
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
          </li>
          <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
            <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
          </li>
        </ul>
      </div>
      
      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" lay-href="home/console.html">
            <span>您好,${user.userName} 欢迎登录!</span>
          </div>
          
          <ul id="menuTop" class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
            
          </ul>
        </div>
      </div>

      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
        <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-down">
          <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
              <a href="javascript:;"></a>
              <dl class="layui-nav-child layui-anim-fadein">
                <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
              </dl>
            </li>
          </ul>
        </div>
        <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
          <ul class="layui-tab-title" id="LAY_app_tabsheader">
            <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
          </ul>
        </div>
      </div>
      
      
      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="home/console.html" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
      </div>
      
      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>

  <script src="../layuiadmin/layui/layui.js"></script>
  <script>
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index','laydate','form','table','jquery','element'],function(){
	  var laydate = layui.laydate,
 	  form = layui.form,
 	  table = layui.table,
 	  $ = layui.jquery;
	  var element = layui.element;
	  var menuList = new Array();
	  var menuInfo = new Object();
	  //创建list
	  <c:forEach var="item" items="${menu}">
	  		menuInfo = new Object();
		  	menuInfo.moduleId = '${item.moduleId}';
		  	menuInfo.moduleName = '${item.moduleName}';
		  	menuInfo.moduleParent = '${item.moduleParent}';
		  	menuInfo.moduleURL = '${item.moduleURL}';
		  	menuInfo.moduleNo = '${item.moduleNo}';
		  	menuInfo.moduleType = '${item.moduleType}';
		  	menuList.push(menuInfo);
	  </c:forEach>
	  
	  var i = 0;
	  while(true){
		  var menu = menuList[i];
		  if(menu.moduleParent==""){
			  	var html =' <li class="layui-nav-item"> '
	            +'<a href="javascript:;" lay-tips='+menu.moduleName+' lay-direction="'+menu.moduleNo+'">'
	            +'<i class="layui-icon layui-icon-component"></i>'
	            +'<cite>'+menu.moduleName+'</cite>'
	            +'</a>'
	            +'<dl id="menuChildren'+menu.moduleId+'" class="layui-nav-child">'
	            +'</dl></li>';
			  	$("#menuTop").append(html);
			  	menuList.splice(i,1);
			  	i--;
		  }else{
			  if($("#menuChildren"+menu.moduleParent).html()==undefined){
				  i++;
				  continue;
			  }
			  var layhref = "";
			  var dlChildren = "";
			  if(menu.moduleURL!=''){
				  layhref = 'lay-href="'+menu.moduleURL+'"';
			  }else{
				  dlChildren='<dl id="menuChildren'+menu.moduleId+'" class="layui-nav-child"></dl>';
			  }
			  var html = '<dd><a '+layhref+' href="javascript:;" lay-direction="'+menu.moduleNo+'">'+menu.moduleName+'</a>'+dlChildren+'</dd>';
			  $("#menuChildren"+menu.moduleParent).append(html);
			  menuList.splice(i,1);
			  i--;
		  }
		  element.init();
		  i++;
		  if(menuList.length<=i){
			  i=0;
		  }
		  if(menuList.length==0){
			  return;
		  }
	  }
  });
  </script>
</body>
</html>