package com.k2.wifidog.service;

import com.k2.wifidog.bean.MacWhite;

public interface MacWhiteService {

	String addMacWhite(MacWhite macWhite, String deviceToken);

	String deleteMacWhite(MacWhite macWhite, String deviceToken);

	String getMacWhites(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
