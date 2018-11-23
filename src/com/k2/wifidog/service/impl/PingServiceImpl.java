package com.k2.wifidog.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.k2.wifidog.bean.Host;
import com.k2.wifidog.bean.IPWhite;
import com.k2.wifidog.bean.MacBlack;
import com.k2.wifidog.dao.Dao;
import com.k2.wifidog.dao.impl.HostDao;
import com.k2.wifidog.dao.impl.IPWhiteDao;
import com.k2.wifidog.dao.impl.MacBlackDao;
import com.k2.wifidog.service.PingService;

public class PingServiceImpl implements PingService{
	private Dao<Host> hostDao=null;
	private Dao<IPWhite> ipwhiteDao=null;
	private Dao<MacBlack> macblackDao=null;
	public PingServiceImpl(){
		if(hostDao==null){
			hostDao=new HostDao();
		}
		if(ipwhiteDao==null){
			ipwhiteDao=new IPWhiteDao();
		}
		if(macblackDao==null){
			macblackDao=new MacBlackDao();
		}
	}
	@Override
	public String getPongStr(String dev_id) {
		List<Host> hosts=new ArrayList<Host>();
		List<IPWhite> ipwhites=new ArrayList<IPWhite>();
		List<MacBlack> macblacks=new ArrayList<MacBlack>();
		try {
			hosts = ((HostDao)hostDao).findByDevId(dev_id);
			ipwhites = ((IPWhiteDao)ipwhiteDao).findByDevId(dev_id);
			macblacks = ((MacBlackDao)macblackDao).findByDevId(dev_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONObject ruleObj=new JSONObject();
		ruleObj.put("host", hosts);
		ruleObj.put("ipwhite", ipwhites);
		ruleObj.put("macblack", macblacks);
		
		JSONObject pongObj=new JSONObject();
		pongObj.put("rule", ruleObj);
		
		String pongStr="Pong result="+pongObj.toString();
		/**
		 * 返回Pong
		 * 格式为:
		 * 		Pong+空格+result=json字符串
		 */
		return pongStr;
	}
	
	/**
	 * for官方版wifidog
	 */
	@Override
	public String getPongStr4Origin() {
		/**
		 * 返回Pong
		 */
		return "Pong";
	}

}
