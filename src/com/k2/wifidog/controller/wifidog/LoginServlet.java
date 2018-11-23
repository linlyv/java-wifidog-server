package com.k2.wifidog.controller.wifidog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * login接口调用该servlet
 * 在用户第一次打开网页时
 * @author hill
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("login接口被调用了:"+request.getRequestURL().toString()+"?"+request.getQueryString());
		
		/**
		 * 根据dev_id的有无判断是否是官方版wifidog
		 * 有dev_id  是apfree版wifidog
		 * 没有dev_id  是padavan版wifidog
		 */
		//1.如果没有dev_id，认为是padavan版wifidog 老毛子固件注释掉下面几行
//		if(request.getParameter("dev_id")==null){
//			/**
//			 * 跳转到用户登录认证页面
//			 */
//			System.out.println("login:官方版wifidog");
//			request.getRequestDispatcher("/WEB-INF/jsp/login4origin.jsp").forward(request, response);
//			return;
//		}
	
		
		/**
		 * 跳转到用户登录认证页面
		 */
		//这一行好像没用
		request.setAttribute("dev_id", "1921681231");
		request.getSession().setAttribute("url", request.getParameter("url"));
		request.getSession().setAttribute("gw_id", request.getParameter("gw_id"));
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	public LoginServlet() {
		super();
	}
}
