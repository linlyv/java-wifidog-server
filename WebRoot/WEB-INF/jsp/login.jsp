<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//rd.forward(request,response);
request.setAttribute("url", request.getAttribute("url") );
//把路由器的网关id传到RegisterServlet
request.getSession().setAttribute("gw_id", request.getSession().getAttribute("gw_id") );
//System.out.println(path);
//System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>wifi登陆认证</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>static/bootstrap/css/starter-template.css">
	<link rel="stylesheet" href="<%=basePath%>static/css/login.css">
	<script type="text/javascript" src="<%=basePath%>images/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		});
	</script>
  </head>
  <body>
	<div class="container">
      <form class="form-signin" role="form" method="post" action="<%=basePath%>loginValidate">
      	<input type="hidden" name="gw_address" value="${param.gw_address}">
        <input type="hidden" name="gw_port" value="${param.gw_port}">
        <input type="hidden" name="gw_id" value="${param.gw_id}">
        <input type="hidden" name="url" value="${param.url}">
        <input type="hidden" name="dev_id" value="${param.dev_id}">
        <input type="hidden" name="mac" value="${param.mac}">
        <h3 class="form-signin-heading">认证登录</h3>
        <input type="text" class="form-control" name="username" placeholder="请输入用户名或者学号" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">点击开始上网</button>
      	 <br/>
      	 <p class="text-muted text-center">      	 	
      	 		<small>登录失败？</small>      	 	
      	 	<a href="<%=basePath%>register.jsp?url=<%=request.getParameter("url")%>" >点此注册</a>
                </p>
      </form>
      
    </div>
    <div class="footer navbar-fixed-bottom " >
        <div class="container">
            <div class="text-center">      
                    <span class="text-center">Copyright &copy;<a href="http://www.baidu.cn/" target="_blank">翻车讯无线wifi</a></span> | 
                    <span> <a href="about.html">关于</a></span> |<br/>
                    <p>建议使用浏览器打开此页面</p>           
            </div>
        </div>
    </div>
  </body>
</html>
