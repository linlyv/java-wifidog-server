package com.k2.wifidog.service;

import com.k2.wifidog.bean.User;

public interface UserService {
	boolean loginValidate(User u, String dev_id);

	String getUsers(String deviceToken);
	String addUser(User user,String deviceToken);

	String deleteUser(User user,String deviceToken);

	String modifyUser(User user,String deviceToken);

	String activeUser(User user,String deviceToken);
}
