package com.k2.wifidog.controller.wifidog;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k2.wifidog.bean.User;
import com.k2.wifidog.dao.impl.UserDao;
import com.k2.wifidog.service.DeviceService;
import com.k2.wifidog.service.UserService;
import com.k2.wifidog.service.impl.DeviceServiceImpl;
import com.k2.wifidog.service.impl.UserServiceImpl;
/**
 * 用户登录验证
 * @author hanyu
 *
 */
public class LoginValidateServlet extends HttpServlet {
	private UserService us=new UserServiceImpl();
	private DeviceService ds=new DeviceServiceImpl();
	private UserDao udao = new UserDao();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try{
			response.setCharacterEncoding("UTF-8");
			//response.setContentType("text/html;charset=UTF-8"); 
	    	
			String gw_address = (String) request.getParameter("gw_address");//路由器地址
			String gw_port = (String) request.getParameter("gw_port");//路由器端口
			String url = (String) request.getParameter("url");//成功后的重定向url
			String gw_id = (String) request.getParameter("gw_id");
			String dev_id = (String) request.getParameter("dev_id");
			String mac=(String) request.getParameter("mac");//客户端mac地址
			//request.setAttribute("dev_id", "1921681231");
			dev_id="1921681231";
			
			//拼接重定向url
			String token=System.currentTimeMillis()+"";
			String redirectUrl="http://"+gw_address+":"+gw_port+"/wifidog/auth?"+"token="+token+"&url="+url+"&dev_id"+dev_id;
			System.out.println("拼接重定向url:"+redirectUrl);
			
			/**
			 * 根据dev_id的有无判断是否是官方版wifidog
			 * 有dev_id  是官方版wifidog
			 * 没有dev_id  是apfree版wifidog
			 */
			//1.padavan版wifidog  *下面须被注释掉*
//			if(request.getParameter("dev_id")==null||"".equals(request.getParameter("dev_id"))){
//				//可根据自己的业务实现认证逻辑
//				System.out.println("loginValidate中的dev_id");
//				response.sendRedirect(redirectUrl);
//				return;
//			}
			//2.apfree版wifidog
			//验证用户名和密码的逻辑
			User u=new User();
			u.setUsername(request.getParameter("username"));			
			u.setPassword(request.getParameter("password"));
			System.out.println("尝试登陆的用户名："+request.getParameter("username"));
			System.out.println("密码："+request.getParameter("password"));
			
			if (u.getUsername().startsWith("201")&&udao.findbyUserName(u.getUsername())!=true) {
				u.setEnable(1);
				u.setAp_id(1);
				udao.add(u);
				System.out.println("新用户（学号）成功添加");
			}
			boolean isValid=us.loginValidate(u, dev_id);
			
			if(isValid){//成功的话，重定向，路由器放行
				System.out.println("认证登录成功");
			
				//把token更新或写入到client表中（用户token验证）
				ds.updateToken(dev_id,mac,token);
				
				response.sendRedirect(redirectUrl);
			}else{
				response.getOutputStream().write("认证登录失败!检查用户名和密码".getBytes("UTF-8"));
			}
		}catch (Exception e) {
			try {
				response.getOutputStream().write("认证登录时出现异常!".getBytes("UTF-8"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
