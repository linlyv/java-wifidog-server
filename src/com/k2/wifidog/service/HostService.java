package com.k2.wifidog.service;

import com.k2.wifidog.bean.Host;

public interface HostService {

	String addHost(Host host, String deviceToken);

	String deleteHost(Host host, String deviceToken);

	String modifyHost(Host host, String deviceToken);

	String getHosts(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
