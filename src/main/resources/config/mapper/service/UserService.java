package com.connext.service;

import java.util.Map;

import com.connext.pojo.User;

public interface UserService {

	//登陆
	public User login(Map<String, String> map);
	
	//注册
	public void register(User user);

	//记录phone个数
	public int checkRegister(String phone);
}