<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//System.out.println(path);
//System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	 <base href="<%=basePath%>">
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>注册账号</title>
    

    <link rel="shortcut icon" href="images/favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name"><img src="images/images/huaji.gif" width="300px"/></h1>

            </div>
            <h3>欢迎使用</h3>
            <p>注册账号</p>
            <form class="m-t" role="form" method="post" action="wifidog/register">
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
               
                <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <input type="checkbox"name="enable" value=1><i></i> 同意协议</label>
                            <input type="hidden" name="ap_id" value=1>
                            <input type="hidden" name="gw_address" value="${param.gw_address}">
					        <input type="hidden" name="gw_port" value="${param.gw_port}">
					        <input type="hidden" name="gw_id" value="${param.gw_id}">
					        <input type="hidden" name="url" value="${param.url}">
					        
					        <input type="hidden" name="mac" value="${param.mac}">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b" onclick="register()">注册</button>

                <p class="text-muted text-center"><small>已经有账户?</small><a href="<%=request.getParameter("url")%>">点此登录</a>
                </p>

            </form>
        </div>
    </div>


<div class="footer navbar-fixed-bottom " >
        <div class="container">
            <div class="text-center">      
                    <span class="text-center">Copyright &copy;<a href="https://www.github.com/linlyv" target="_blank">个人主页</a></span> | 
                    <span> <a href="about.html">老毛子固件网络认证系统</a></span> |           
            </div>
        </div>
</div>
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    

    
    

</body>

</html>
