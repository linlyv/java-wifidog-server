package com.k2.wifidog.service;

import com.k2.wifidog.bean.MacBlack;

public interface MacBlackService {

	String addMacBlack(MacBlack macBlack, String deviceToken);

	String deleteMacBlack(MacBlack macBlack, String deviceToken);

	String getMacBlacks(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
