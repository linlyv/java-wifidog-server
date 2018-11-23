package com.k2.wifidog.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.k2.wifidog.service.DeviceService;
import com.k2.wifidog.service.impl.DeviceServiceImpl;
/**
 * for http://ip/api/client_list
 * @author hill
 *
 */
public class DeviceServlet extends HttpServlet {
	DeviceService ds=new DeviceServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("client_list接口被调用了");
		String device_token=req.getParameter("device_token");
		String respStr=ds.getDevices(device_token);
		resp.getOutputStream().write(respStr.getBytes());
	}
}
