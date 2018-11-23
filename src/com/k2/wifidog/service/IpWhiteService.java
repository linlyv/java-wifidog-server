package com.k2.wifidog.service;

import com.k2.wifidog.bean.IPWhite;

public interface IpWhiteService {

	String addIpWhite(IPWhite ipwhite, String deviceToken);

	String deleteIpWhite(IPWhite ipwhite, String deviceToken);

	String getIpWhites(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
