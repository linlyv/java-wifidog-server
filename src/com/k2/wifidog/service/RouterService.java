package com.k2.wifidog.service;

import com.k2.wifidog.bean.Router;

public interface RouterService {

	String getStatus(String deviceToken);

	void addByDevId(Router router,String devId);
	
}
