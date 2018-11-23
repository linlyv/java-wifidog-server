package com.k2.wifidog.controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k2.wifidog.bean.User;
import com.k2.wifidog.dao.impl.UserDao;
import com.k2.wifidog.test.ApDaoTest;

public class RegisterServlet extends HttpServlet {
		
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao udao = new UserDao();
	private User u=new User();
    private ApDaoTest addrouter = new ApDaoTest();
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
    	String path = req.getContextPath();
    	String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
    	resp.setContentType("text/html;charset=UTF-8"); 
    	PrintWriter out = resp.getWriter();
    	 System.out.println("注册接口被调用了……");
		 u.setUsername(req.getParameter("username"));
		 u.setPassword(req.getParameter("password"));
		 if (req.getSession().getAttribute("gw_id").toString()!=null) {
			 try {
				 	
					if (addrouter.AddRouter(req.getSession().getAttribute("gw_id").toString(), "1921681231")) {
						System.out.println("路由添加成功");
					}
				
			 } catch (SQLException e1) {	
				e1.printStackTrace();
			 }
		 }
		 
		 if(req.getParameter("enable")==null) {
			 out.print("<h2>");
			 out.print("用户："+u.getUsername()+" 请同意协议");				 
			 out.print("</h2>");
		 }
		 u.setEnable(Integer.valueOf(req.getParameter("enable"))  );
		 u.setAp_id(Integer.valueOf(req.getParameter("ap_id"))  );
		 System.out.println("注册接口被调用了……获取到数据");
		 try {
			 //添加用户到数据库
			udao.add(u);
			System.out.println("用户注册成功！");
			out.print("<h2>");
			out.print("用户："+u.getUsername()+" 成功注册");	
			out.print("<a href='http://www.baidu.com'>点此登录上网</a>");
			out.print("</h2>");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
}
