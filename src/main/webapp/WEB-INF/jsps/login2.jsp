<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
    <title>河南省乳源追溯管理系统</title>
    <script type="text/javascript" src="../../jquery.min.js"></script>
    
    <style type="text/css">
        body {
            margin: 0px;
        }

        #divtop {
            width: 100%;
            height: 80px;
            background-image: url("../../images/TopLine.png");
        }

        #divlogo {
            float: left;
            margin-top: 5px;
            margin-left: 240px;
            width: 61px;
            height: 60px;
            background-image: url("../../images/logo.png");
        }

        #titleName {
            float: left;
            line-height: 60px;
            margin-left: 10px;
            font-size: 28px;
            letter-spacing: 2px;
            color:#0d8ccb;
        }

        #titleVision {
            margin-top: 25px;
            float: left;
            line-height: 30px;
            margin-left: 10px;
            font-size: 16px;
            vertical-align: bottom;
        }

        #divbody {
            margin-top: 3%;
            margin-left: 200px;
            background-image: url("../../images/Indexbg.png");
            background-repeat: no-repeat;
            height: 480px;
            width: 1024px;
            background-size: 915px 450px;
           
        }

        #divLogin {
            float: left;
            margin-top: 110px;
            margin-left: 550px;
            height: 300px;
            width: 360px;
        }

        #divuser {
            float: left;
            width: 80%;
            margin-left: 10%;
            margin-top: 10px;
            height: 40px;
            line-height: 40px;
            text-anchor: middle;
            border-bottom: solid 1px #808080;
        }

        #UserName {
            border: none;
            font-size: 16px;
            text-align: center;
            background: none;
        }

            #UserName:focus {
                border: none;
                outline: none;
            }


        #divPass {
            float: left;
            width: 80%;
            margin-left: 10%;
            margin-top: 10px;
            height: 40px;
            line-height: 40px;
            text-anchor: middle;
            border-bottom: solid 1px #808080;
        }

        #Password {
            border: none;
            font-size: 16px;
            text-align: center;
            background: none;
        }

            #Password:focus {
                border: none;
                outline: none;
            }

        #btnLogin {
            float: left;
            width: 80%;
            margin-left: 10%;
            margin-top: 20px;
            height: 30px;
            line-height: 30px;
            text-anchor: middle;
            text-align: center;
            font-size: 20px;
            color: #ffffff;
            font-weight: bolder;
            background-color: #0E4E7A;
            ilter: alpha(opacity:100);
            opacity: 1;
            -moz-opacity: 1;
            -khtml-opacity: 1;
        }

            #btnLogin:hover {
                background-color: #0E8E8C;
            }
            #divReg
            {
                float:left;
                width:100%;
                line-height:16px;
                text-align:center;
                font-size:12px;
            }
            #divReg div{
                margin-top:5px;
                float:left;
                width:300px;
            }
    </style>
</head>
<body>
    <div id="divtop">
        <div id="systitle">
            <div id="divlogo"></div>
            <div id="titleName">河南省乳源追溯管理系统</div>
            <div id="titleVision">V1.0</div>
        </div>
    </div>
    <div id="divbody">

        <div id="divLogin">
		<form id="loginForm" action="/login" method="post">
            <div id="divuser">
                <div style="float:left;width:20%; font-size:16px">用户名:</div>
                <div style="float:left;width:70%">
                    <input type="text" id="UserName" name="loginName" value="test" data-options="required:true,validType:'length[1,32]'" />
                </div>
            </div>
            <div id="divPass">
                <div style="float:left;width:20%; font-size:16px">密    码:</div>
                <div style="float:left;width:70%">
                    <input type="password" id="Password" name="loginPWD" data-options="required:true,validType:'length[1,32]'" />
                </div>
            </div>
        </form>
            <div id="btnLogin">
                登录
            </div>
            <div style="position:relative; top:20px; left:50px; width:200px; color:Red;" id="divMessage">
            ${message}
            </div>
        </div>

        <div id="divReg">
            <div>版权所有@2012-2018湖南振容科技有限公司</div>
            <div>湘ICP备17003880号</div>
        </div>

    </div>
</body>
</html>
<script type="text/javascript">
    $(function () {
        //实现用户的登录信息
        LoginUserInfo();
    });

    //异步实现用户的登录
    function LoginUserInfo(LoginUserInfo) {
        $("#btnLogin").click(function () {
			$("#loginForm").submit();        	
        });
    }
    //回车事件（回车登录）
    document.onkeydown = function (e) {
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
            $("#btnLogin").click();
        }
    }
</script>

